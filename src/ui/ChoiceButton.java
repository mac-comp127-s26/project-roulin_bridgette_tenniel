package ui;

import edu.macalester.graphics.FontStyle;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Rectangle;
import java.awt.Color;

public class ChoiceButton {
    private final double x;
    private final double y;
    private final double width;
    private final double height;
    private final GraphicsGroup group;
    private final Rectangle background;
    private final GraphicsText label;
    private boolean visible;

    public ChoiceButton(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        group = new GraphicsGroup(x, y);

        background = new Rectangle(0, 0, width, height);
        background.setFilled(true);
        background.setFillColor(new Color(245, 228, 197));
        background.setStrokeColor(new Color(92, 59, 33));
        background.setStrokeWidth(2);

        label = new GraphicsText("");
        label.setPosition(16, 30);
        label.setFont("Georgia, Serif", FontStyle.PLAIN, 18);
        label.setWrappingWidth(width - 32);
        label.setFillColor(new Color(45, 32, 25));

        group.add(background);
        group.add(label);
        visible = true;
    }

    public GraphicsGroup getGroup() {
        return group;
    }

    public void setText(String text) {
        label.setText(text);
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
        if (visible) {
            group.setPosition(x, y);
        } else {
            group.setPosition(-5000, -5000);
        }
    }

    public boolean contains(double px, double py) {
        return visible
            && px >= x
            && px <= x + width
            && py >= y
            && py <= y + height;
    }
}
