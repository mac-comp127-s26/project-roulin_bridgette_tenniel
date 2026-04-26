import engine.StoryEngine;
import story.StoryData;
import ui.VisualNovelWindow;

public class Main {
    public static void main(String[] args) {
        StoryEngine engine = new StoryEngine(StoryData.createStory());
        new VisualNovelWindow(engine);
    }
}
