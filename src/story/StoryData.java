package story;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class StoryData {
    private StoryData() {
    }

    public static Map<String, Object> createStory() {
        Map<String, Object> story = new HashMap<>();
        story.put("title", "President Trump's 2020 Adventure");
        story.put("intro", introScene());
        story.put("opening", openingScene());
        story.put("cast", castScene());
        story.put("initialStats", stats(-2, 0, 0));
        story.put("actionPool", buildActionPool());
        story.put("days", buildDays());
        story.put("endings", buildEndings());
        return story;
    }

    private static Map<String, Object> introScene() {
        return scene(
            "intro",
            "opening",
            "Welcome",
            "res/black.png",
            "In this game, you need to play as Donald Trump to make a series of decision to win the 2020 election.  You need to click on different buttons to make different decisions, and this will decide your destiny.",
            option("A", "Start Story", null)
        );
    }

    private static Map<String, Object> openingScene() {
        return scene(
            "opening",
            "opening",
            "A Strange Morning",
            "res/black.png",
            "You wake up in the White House with a terrifying memory.\n"
                + "In another timeline, you lost the 2020 election.\n"
                + "This time, you have five days to change everything.",
            option("A", "Begin the campaign", null)
        );
    }

    private static Map<String, Object> castScene() {
        return scene(
            "cast",
            "cast",
            "Cast",
            "res/cast.png",
            "Thanks for playing President Trump's 2020 Adventure.\n"
                + "Created by Ruolin Shen, Tianqi Zhao, and Bridgette Mi.",
            option("A", "The End", null)
        );
    }

    private static List<Map<String, Object>> buildDays() {
        List<Map<String, Object>> days = new ArrayList<>();

        days.add(day(
            1,
            twitterRound(1, "res/news1-1.png",
                "Chris Wallace says your cognitive test was easy. The morning show is laughing at you."),
            fixedRound("day1_press", "press_day1"),
            chooseRound(3, "Evening Action",
                "The day is not over yet. Choose one action for tonight.")
        ));

        days.add(day(
            2,
            twitterRound(2, "res/news2-1.png",
                "Mount Rushmore rumors are back in the headlines, and reporters want a reaction."),
            chooseRound(2, "Afternoon Decision",
                "You have time for one major campaign move this afternoon."),
            chooseRound(3, "Evening Action",
                "Choose a different action for the evening. You cannot repeat today's earlier action.")
        ));

        days.add(day(
            3,
            twitterRound(3, "res/news3-1.png",
                "A tax story is dominating cable news, and your aides are panicking."),
            fixedRound("day3_press", "press_day3"),
            chooseRound(3, "Evening Action",
                "The cameras are gone. Pick one more move before midnight.")
        ));

        days.add(day(
            4,
            twitterRound(4, "res/news4-1.png",
                "The Walter Reed SUV ride is under attack again. Everyone is waiting for your tweet."),
            fixedRound("day4_debate", "debate_day4"),
            chooseRound(3, "Post-Debate Move",
                "The debate is over. Pick one follow-up action for the campaign.")
        ));

        days.add(day(
            5,
            twitterRound(5, "res/news5-1.png",
                "The Pence fly moment still dominates the news cycle on the final morning."),
            chooseRound(2, "Final Day Strategy",
                "There is still time for one more daytime move before the last push."),
            chooseRound(3, "Final Night Action",
                "Choose your final action. It must be different from today's earlier action.")
        ));

        return days;
    }

    private static Map<String, Object> buildActionPool() {
        Map<String, Object> pool = new HashMap<>();

        pool.put("rally", scene(
            "action_rally",
            "action",
            "Campaign Rally",
            "res/rally action 1.png",
            "A crowd of supporters is waiting for a big performance.\n"
                + "Do you keep the message controlled, or go fully theatrical?",
            option("A", "Play it safe on stage", stats(1, 1, 1)),
            option("B", "Go all out for the crowd", stats(2, 2, 2))
        ));

        pool.put("donor", scene(
            "action_donor",
            "action",
            "Meet With Donors",
            "res/donor meeting.png",
            "A private donor meeting could help your campaign machine stay alive.",
            option("A", "Attend the donor meeting", stats(3, 1, 0))
        ));

        pool.put("staff", scene(
            "action_staff",
            "action",
            "Meet With Staff",
            "res/meeting staff.png",
            "Your campaign staff wants a serious strategy meeting before the next news cycle.",
            option("A", "Meet with your staff", stats(2, 2, -1))
        ));

        pool.put("press_day1", scene(
            "day1_press_scene",
            "fixed",
            "Press Conference",
            "res/press conference.png",
            "A reporter asks whether you really think the public is too stupid to understand your brilliance.",
            option("A", "Answer carefully", stats(-1, -1, 1)),
            option("B", "Answer aggressively", stats(-2, -2, 2)),
            option("C", "Refuse to answer", stats(-3, -3, 3))
        ));

        pool.put("press_day3", scene(
            "day3_press_scene",
            "fixed",
            "Press Conference",
            "res/press conference-2.png",
            "Reporters demand an explanation for the latest tax story before the afternoon cycle closes.",
            option("A", "Answer carefully", stats(-1, -1, 1)),
            option("B", "Answer aggressively", stats(-2, -2, 2)),
            option("C", "Refuse to answer", stats(-3, -3, 3))
        ));

        pool.put("debate_day4", scene(
            "day4_debate_scene",
            "fixed",
            "Presidential Debate",
            "res/president debate.png",
            "The nation is watching. You step onto the stage and prepare for another chaotic night.",
            option("A", "Take the debate stage", stats(-1, -1, -1))
        ));

        return pool;
    }

    private static List<Map<String, Object>> buildEndings() {
        List<Map<String, Object>> endings = new ArrayList<>();
        endings.add(ending(
            "win",
            "res/win.png",
            "Victory",
            "The election is over, and you stay in power.\n"
                + "High support and stable control carry you to victory."
        ));
        endings.add(ending(
            "war",
            "res/war.png",
            "War Ending",
            "Your campaign loses all stability.\n"
                + "You reject the result and push the country toward open chaos."
        ));
        endings.add(ending(
            "lose",
            "res/lose.png",
            "Lose Ending",
            "You lose the election.\n"
                + "Your support never recovered, and your anger only kept growing."
        ));
        endings.add(ending(
            "sad",
            "res/sad.png",
            "Sad Ending",
            "You lose the election and retreat into bitterness.\n"
                + "There is no final burst of rage, only defeat."
        ));
        return endings;
    }

    private static Map<String, Object> day(int dayNumber, Map<String, Object>... rounds) {
        Map<String, Object> day = new HashMap<>();
        day.put("dayNumber", dayNumber);

        List<Map<String, Object>> roundList = new ArrayList<>();
        for (Map<String, Object> round : rounds) {
            roundList.add(round);
        }
        day.put("rounds", roundList);
        return day;
    }

    private static Map<String, Object> twitterRound(int dayNumber, String image, String headline) {
        Map<String, Object> round = new HashMap<>();
        round.put("mode", "fixed");
        round.put("id", "day" + dayNumber + "_twitter");
        round.put("scene", scene(
            "day" + dayNumber + "_twitter_scene",
            "twitter",
            "Morning Twitter",
            image,
            headline + "\nDo you respond on Twitter?",
            option("A", "Tweet opinion", stats(1, -1, 1)),
            option("B", "Tweet something reckless", stats(-1, -2, 2)),
            option("C", "Do not tweet", stats(0, 1, 0))
        ));
        return round;
    }

    private static Map<String, Object> fixedRound(String id, String actionId) {
        Map<String, Object> round = new HashMap<>();
        round.put("mode", "fixed");
        round.put("id", id);
        round.put("actionId", actionId);
        return round;
    }

    private static Map<String, Object> chooseRound(int roundNumber, String title, String text) {
        Map<String, Object> round = new HashMap<>();
        round.put("mode", "choose");
        round.put("roundNumber", roundNumber);
        round.put("title", title);
        round.put("text", text);
        round.put("image", "res/decide.png");
        round.put("availableActions", List.of("rally", "donor", "staff"));
        return round;
    }

    private static Map<String, Object> scene(
        String id,
        String type,
        String title,
        String image,
        String text,
        Map<String, Object>... options
    ) {
        Map<String, Object> scene = new HashMap<>();
        scene.put("id", id);
        scene.put("type", type);
        scene.put("title", title);
        scene.put("image", image);
        scene.put("text", text);

        List<Map<String, Object>> optionList = new ArrayList<>();
        for (Map<String, Object> option : options) {
            optionList.add(option);
        }
        scene.put("options", optionList);
        return scene;
    }

    private static Map<String, Object> option(String key, String label, Map<String, Integer> effects) {
        Map<String, Object> option = new HashMap<>();
        option.put("key", key);
        option.put("label", label);
        if (effects != null) {
            option.put("effects", effects);
        }
        return option;
    }

    private static Map<String, Object> ending(String id, String image, String title, String text) {
        Map<String, Object> ending = new HashMap<>();
        ending.put("id", id);
        ending.put("image", image);
        ending.put("title", title);
        ending.put("text", text);
        return ending;
    }

    private static Map<String, Integer> stats(int support, int stability, int mood) {
        Map<String, Integer> stats = new HashMap<>();
        stats.put("support", support);
        stats.put("stability", stability);
        stats.put("mood", mood);
        return stats;
    }
}
