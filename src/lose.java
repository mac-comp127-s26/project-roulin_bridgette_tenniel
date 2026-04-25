import java.util.LinkedHashMap;
import java.util.Map;

public class lose {
    public static void main(String[] args) {
        // First sentence
        Map<String, Object> line1 = new LinkedHashMap<>();
        line1.put("background", "res/lose.png"); // bg
        line1.put("text", "We have lost the election, all have gone..."); 

        // Second sentence
        Map<String, Object> line2 = new LinkedHashMap<>();
        line2.put("background", "res/lose.png"); 
        line2.put("text", "But that's all. At least I can still enjoy my all done steak with tomato sauce, together with my favorite coke. ");

        // Third sentence
        Map<String, Object> line3 = new LinkedHashMap<>();
        line3.put("background", "res/lose.png");
        line3.put("text", "That's enough, I guess it's time to enjoy my life...");
    }
}
