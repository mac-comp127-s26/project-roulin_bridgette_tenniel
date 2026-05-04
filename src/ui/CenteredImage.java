package ui;

import edu.macalester.graphics.Image;

public class CenteredImage {
    private final Image image;
    private final double areaWidth;
    private final double areaHeight;

    public CenteredImage(double areaWidth, double areaHeight) {
        this.areaWidth = areaWidth;
        this.areaHeight = areaHeight;
        this.image = new Image(0, 0);
    }

    public Image getGraphics() {
        return image;
    }

    public void updateImage(String rawPath) {
        String cleanPath = rawPath;
        if (rawPath.startsWith("res/")) {
            cleanPath = rawPath.substring(4);
        }
        image.setImagePath(cleanPath);
        image.setScale(1.0);

        double w = image.getImageWidth();
        double h = image.getImageHeight();

        if (w == 0 || h == 0) {
            return; 
        }
        double scale = Math.max(areaWidth / w, areaHeight / h);
        image.setScale(scale);
        image.setCenter(areaWidth / 2.0, areaHeight / 2.0);
    }
}