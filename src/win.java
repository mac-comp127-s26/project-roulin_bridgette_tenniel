import java.util.LinkedHashMap;
import java.util.Map;

public class win{
    public static void main(String[] args) {
        // First sentence
        Map<String, Object> line1 = new LinkedHashMap<>();
        line1.put("background", "res/win.png"); // 设置背景
        line1.put("text", "The election is end, for I'm the president!"); // 设置台词

        // Second sentence
        Map<String, Object> line2 = new LinkedHashMap<>();
        // bg holds
        line2.put("background", "res/win.png"); 
        line2.put("text", "From the high mountains of the north, to the great oceans of the south, we GOP rule, I rule.");

        // Third sentence
        Map<String, Object> line3 = new LinkedHashMap<>();
        line3.put("background", "res/win.png");
        line3.put("text", "Our glory, our power... will last for ten thousand years!");
    }
}
