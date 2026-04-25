package story;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class StoryData {
    private StoryData() {
    }

    public static Map<String, Object> createStory() {
        Map<String, Object> story = new HashMap<>();

        story.put("title", "President Trump's Adventure");
        story.put("days", new ArrayList<Map<String, Object>>());
        story.put("endings", new ArrayList<Map<String, Object>>());
        story.put("startingMoney", 0);
        story.put("startingStability", 0);
        story.put("startingSupport", 0);
        story.put("startingMood", 0);

        return story;
    }
}
