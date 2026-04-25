import java.util.LinkedHashMap;
import java.util.Map;

public class war {
    public static void main(String[] args) {
        // First Sentence
        Map<String, Object> line1 = new LinkedHashMap<>();
        line1.put("background", "res/war.png"); // bg
        line1.put("text", "The nasty democrats have stole our victory, but I won't give up.");

        // Second sentence
        Map<String, Object> line2 = new LinkedHashMap<>();
        line2.put("background", "res/war.png"); 
        line2.put("text", "My dear supporters, prepare to march to Washington.");
    }
}
