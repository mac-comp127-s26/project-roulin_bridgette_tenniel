package ui;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.FontStyle;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Rectangle;
import engine.StoryEngine;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VisualNovelWindow {
    private static final int WINDOW_WIDTH = 1200;
    private static final int WINDOW_HEIGHT = 800;
    private static final int MAX_BUTTONS = 3;

    private final StoryEngine engine;
    private final CanvasWindow window;
    private final Image backgroundImage;
    private final Rectangle dialogueBox;
    private final Rectangle statsPanel;
    private final GraphicsText titleText;
    private final GraphicsText bodyText;
    private final GraphicsText statsText;
    private final GraphicsText dayText;
    private final List<ChoiceButton> buttons;

    public VisualNovelWindow(StoryEngine engine) {
        this.engine = engine;
        this.window = new CanvasWindow(engine.getTitle(), WINDOW_WIDTH, WINDOW_HEIGHT);
        this.window.setBackground(new Color(216, 230, 241));

        backgroundImage = new Image(0, 0);

        dialogueBox = new Rectangle(40, 500, 1120, 250);
        dialogueBox.setFilled(true);
        dialogueBox.setFillColor(new Color(252, 245, 233));
        dialogueBox.setStrokeColor(new Color(92, 59, 33));
        dialogueBox.setStrokeWidth(3);

        statsPanel = new Rectangle(900, 20, 250, 120);
        statsPanel.setFilled(true);
        statsPanel.setFillColor(new Color(255, 248, 236));
        statsPanel.setStrokeColor(new Color(92, 59, 33));
        statsPanel.setStrokeWidth(2);

        titleText = new GraphicsText("");
        titleText.setPosition(70, 540);
        titleText.setFont("Georgia, Serif", FontStyle.BOLD, 24);
        titleText.setFillColor(new Color(60, 38, 22));

        bodyText = new GraphicsText("");
        bodyText.setPosition(70, 580);
        bodyText.setFont("Georgia, Serif", FontStyle.PLAIN, 19);
        bodyText.setWrappingWidth(560);
        bodyText.setFillColor(new Color(45, 32, 25));

        dayText = new GraphicsText("");
        dayText.setPosition(70, 70);
        dayText.setFont("Georgia, Serif", FontStyle.BOLD, 30);
        dayText.setFillColor(Color.WHITE);

        statsText = new GraphicsText("");
        statsText.setPosition(920, 60);
        statsText.setFont("Georgia, Serif", FontStyle.PLAIN, 20);
        statsText.setFillColor(new Color(45, 32, 25));

        buttons = new ArrayList<>();
        for (int i = 0; i < MAX_BUTTONS; i++) {
            ChoiceButton button = new ChoiceButton(690, 545 + i * 62, 430, 52);
            buttons.add(button);
        }

        window.add(backgroundImage);
        window.add(dayText);
        window.add(dialogueBox);
        window.add(statsPanel);
        window.add(titleText);
        window.add(bodyText);
        window.add(statsText);
        for (ChoiceButton button : buttons) {
            window.add(button.getGroup());
        }

        window.onClick(event -> handleClick(event.getPosition().getX(), event.getPosition().getY()));
        render();
    }

    private void handleClick(double x, double y) {
        if (engine.isCastScreen()) {
            return;
        }

        List<Map<String, Object>> options = engine.getCurrentOptions();
        for (int i = 0; i < options.size(); i++) {
            if (buttons.get(i).contains(x, y)) {
                engine.chooseOption(i);
                render();
                return;
            }
        }
    }

    private void render() {
        if (engine.isFinished() && !engine.isCastScreen()) {
            renderEnding();
        } else if (engine.isCastScreen()) {
            renderCast();
        } else {
            renderScene(engine.getCurrentScene(), engine.getCurrentOptions());
        }
        window.draw();
    }

    private void renderScene(Map<String, Object> scene, List<Map<String, Object>> options) {
        if (engine.getCurrentDayNumber() == 0) {
            dayText.setText("Opening");
        } else {
            dayText.setText("Day " + engine.getCurrentDayNumber() + "  Round " + engine.getCurrentRoundNumber());
        }
        titleText.setText((String) scene.get("title"));
        bodyText.setText((String) scene.get("text"));
        statsText.setText(buildStatsText());

        setBackgroundPath((String) scene.get("image"));

        for (int i = 0; i < buttons.size(); i++) {
            if (i < options.size()) {
                buttons.get(i).setVisible(true);
                buttons.get(i).setText(options.get(i).get("key") + ". " + options.get(i).get("label"));
            } else {
                buttons.get(i).setVisible(false);
            }
        }
    }

    private void renderEnding() {
        Map<String, Object> ending = engine.getCurrentScene();

        dayText.setText("Ending");
        titleText.setText((String) ending.get("title"));
        bodyText.setText(ending.get("text") + "\n\nClick the button to continue to the cast.");
        statsText.setText(buildStatsText());

        setBackgroundPath((String) ending.get("image"));

        List<Map<String, Object>> options = engine.getCurrentOptions();
        for (int i = 0; i < buttons.size(); i++) {
            if (i < options.size()) {
                buttons.get(i).setVisible(true);
                buttons.get(i).setText(options.get(i).get("key") + ". " + options.get(i).get("label"));
            } else {
                buttons.get(i).setVisible(false);
            }
        }
    }

    private void renderCast() {
        Map<String, Object> cast = engine.getCurrentScene();

        dayText.setText("Cast");
        titleText.setText((String) cast.get("title"));
        bodyText.setText((String) cast.get("text"));
        statsText.setText(buildStatsText());

        setBackgroundPath((String) cast.get("image"));

        for (ChoiceButton button : buttons) {
            button.setVisible(false);
        }
    }

    private void setBackgroundPath(String rawPath) {
        String normalizedPath = rawPath.startsWith("res/") ? rawPath.substring(4) : rawPath;
        backgroundImage.setImagePath(normalizedPath);
        fitBackground();
    }

    private void fitBackground() {
        double imageWidth = backgroundImage.getImageWidth();
        double imageHeight = backgroundImage.getImageHeight();
        if (imageWidth <= 0 || imageHeight <= 0) {
            return;
        }

        double scale = Math.max(WINDOW_WIDTH / imageWidth, WINDOW_HEIGHT / imageHeight);
        backgroundImage.setScale(scale);
        backgroundImage.setPosition(
            (WINDOW_WIDTH - imageWidth * scale) / 2.0,
            (WINDOW_HEIGHT - imageHeight * scale) / 2.0
        );
    }

    private String buildStatsText() {
        return "Support: " + engine.getState().getSupport()
            + "\nStability: " + engine.getState().getStability()
            + "\nMood: " + engine.getState().getMood();
    }
}
