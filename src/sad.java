import java.util.LinkedHashMap;
import java.util.Map;

public class sad{
    public static void main(String[] args) {
        // First sentence
        Map<String, Object> line1 = new LinkedHashMap<>();
        line1.put("background", "res/sad.png"); // bg
        line1.put("text", "I have lost everything, nothing is left now"); 

        // Second sentence
        Map<String, Object> line2 = new LinkedHashMap<>();
        // bg holds
        line2.put("background", "res/sad.png"); 
        line2.put("text", "Seeing the country under Democrats");

        // Third sentence
        Map<String, Object> line3 = new LinkedHashMap<>();
        line3.put("background", "res/sad.png");
        line3.put("text", "All have gone...");
    }
}
