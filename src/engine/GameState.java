package engine;

import java.util.Map;

public class GameState {
    private int support;
    private int stability;
    private int mood;

    public GameState(Map<String, Integer> initialStats) {
        this.support = initialStats.getOrDefault("support", 0);
        this.stability = initialStats.getOrDefault("stability", 0);
        this.mood = initialStats.getOrDefault("mood", 0);
    }

    public void apply(Map<String, Integer> effects) {
        support += effects.getOrDefault("support", 0);
        stability += effects.getOrDefault("stability", 0);
        mood += effects.getOrDefault("mood", 0);
    }

    public int getSupport() {
        return support;
    }

    public int getStability() {
        return stability;
    }

    public int getMood() {
        return mood;
    }

    public String summary() {
        return "support=" + support + ", stability=" + stability + ", mood=" + mood;
    }
}
