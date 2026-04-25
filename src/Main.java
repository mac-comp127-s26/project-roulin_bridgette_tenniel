import java.util.Map;
import story.StoryData;

public class Main {
    public static void main(String[] args) {
        Map<String, Object> story = StoryData.createStory();
        System.out.println("Story loaded.");
        System.out.println(story);
    }
}
