import java.util.LinkedHashMap;
import java.util.Map;

public class Begin {
    public static void main(String[] args) {
        Map<String, String> scriptMap = new LinkedHashMap<>();

        scriptMap.put("Trump", "I had a dream. In the dream, I lost the election in 2020.");
        
        scriptMap.put("Trump", "Despicable democrats have stole my victory. This time, I'll make them pay.");

        //Print out
        for (Map.Entry<String, String> entry : scriptMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
