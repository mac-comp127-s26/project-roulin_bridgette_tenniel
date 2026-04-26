package engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StoryEngine {
    private final Map<String, Object> story;
    private final GameState state;
    private boolean openingActive = true;
    private int dayIndex;
    private int roundIndex;
    private boolean finished;
    private String selectedActionId;
    private final Set<String> usedActionsToday = new HashSet<>();

    public StoryEngine(Map<String, Object> story) {
        this.story = story;
        this.state = new GameState(castIntMap(story.get("initialStats")));
    }

    public GameState getState() {
        return state;
    }

    public String getTitle() {
        return (String) story.get("title");
    }

    public int getCurrentDayNumber() {
        if (openingActive) {
            return 0;
        }
        return (Integer) getCurrentDay().get("dayNumber");
    }

    public int getCurrentRoundNumber() {
        if (openingActive || finished) {
            return 0;
        }
        return roundIndex + 1;
    }

    public boolean isFinished() {
        return finished;
    }

    public Map<String, Object> getCurrentScene() {
        if (openingActive) {
            return castSceneMap(story.get("opening"));
        }

        if (selectedActionId != null) {
            return getActionScene(selectedActionId);
        }

        Map<String, Object> round = getCurrentRound();
        String mode = (String) round.get("mode");

        if ("fixed".equals(mode)) {
            if (round.containsKey("scene")) {
                return castSceneMap(round.get("scene"));
            }
            return getActionScene((String) round.get("actionId"));
        }

        return buildChooserScene(round);
    }

    public List<Map<String, Object>> getCurrentOptions() {
        return castSceneList(getCurrentScene().get("options"));
    }

    public void chooseOption(int optionIndex) {
        if (finished) {
            return;
        }

        Map<String, Object> option = getCurrentOptions().get(optionIndex);

        if (openingActive) {
            openingActive = false;
            return;
        }

        if (selectedActionId != null) {
            state.apply(castIntMap(option.get("effects")));
            usedActionsToday.add(selectedActionId);
            selectedActionId = null;
            advanceRound();
            return;
        }

        Map<String, Object> round = getCurrentRound();
        String mode = (String) round.get("mode");

        if ("choose".equals(mode)) {
            selectedActionId = (String) option.get("actionId");
            return;
        }

        if (option.containsKey("effects")) {
            state.apply(castIntMap(option.get("effects")));
        }
        advanceRound();
    }

    public Map<String, Object> getEnding() {
        String endingId;
        if (state.getStability() < 3) {
            endingId = "war";
        } else if (state.getSupport() >= 5) {
            endingId = "win";
        } else if (state.getMood() >= 6) {
            endingId = "lose";
        } else {
            endingId = "sad";
        }

        for (Map<String, Object> ending : castSceneList(story.get("endings"))) {
            if (endingId.equals(ending.get("id"))) {
                return ending;
            }
        }
        throw new IllegalStateException("Missing ending: " + endingId);
    }

    private void advanceRound() {
        roundIndex++;
        if (roundIndex < castSceneList(getCurrentDay().get("rounds")).size()) {
            return;
        }

        dayIndex++;
        roundIndex = 0;
        usedActionsToday.clear();

        List<Map<String, Object>> days = castSceneList(story.get("days"));
        if (dayIndex >= days.size()) {
            finished = true;
        }
    }

    private Map<String, Object> getCurrentDay() {
        return castSceneList(story.get("days")).get(dayIndex);
    }

    private Map<String, Object> getCurrentRound() {
        return castSceneList(getCurrentDay().get("rounds")).get(roundIndex);
    }

    private Map<String, Object> getActionScene(String actionId) {
        return castSceneMap(castSceneMap(story.get("actionPool")).get(actionId));
    }

    private Map<String, Object> buildChooserScene(Map<String, Object> round) {
        Map<String, Object> chooser = new HashMap<>();
        chooser.put("id", "chooser_day" + getCurrentDayNumber() + "_round" + getCurrentRoundNumber());
        chooser.put("type", "chooser");
        chooser.put("title", round.get("title"));
        chooser.put("text", round.get("text"));
        chooser.put("image", round.get("image"));

        List<Map<String, Object>> options = new ArrayList<>();
        List<String> availableActions = castStringList(round.get("availableActions"));
        int keyIndex = 0;
        for (String actionId : availableActions) {
            if (!usedActionsToday.contains(actionId)) {
                Map<String, Object> scene = getActionScene(actionId);
                Map<String, Object> option = new HashMap<>();
                option.put("key", String.valueOf((char) ('A' + keyIndex)));
                option.put("label", scene.get("title"));
                option.put("actionId", actionId);
                options.add(option);
                keyIndex++;
            }
        }

        chooser.put("options", options);
        return chooser;
    }

    @SuppressWarnings("unchecked")
    private List<Map<String, Object>> castSceneList(Object value) {
        return (List<Map<String, Object>>) value;
    }

    @SuppressWarnings("unchecked")
    private Map<String, Object> castSceneMap(Object value) {
        return (Map<String, Object>) value;
    }

    @SuppressWarnings("unchecked")
    private Map<String, Integer> castIntMap(Object value) {
        return (Map<String, Integer>) value;
    }

    @SuppressWarnings("unchecked")
    private List<String> castStringList(Object value) {
        return (List<String>) value;
    }
}
