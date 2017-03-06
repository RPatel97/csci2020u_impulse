package lab07;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PieChart {
    private static final int PIE_MAX = 360;

    private GraphicsContext graphics;
    private Map<String, Float> data;
    private Map<String, Color> dataColors;
    private int x;
    private int y;
    private int width;
    private int height;

    public PieChart(GraphicsContext graphics, int x, int y, int width, int height) {
        this.graphics = graphics;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.dataColors = new HashMap<>();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Map<String, Float> getData() {
        return data;
    }

    public void setData(Map<String, Float> data) {
        this.data = data;
        this.dataColors.clear();

        Random random = new Random();
        for (Map.Entry<String, Float> pair : data.entrySet()) {
            this.dataColors.put(pair.getKey(), Color.rgb(random.nextInt(255), random.nextInt(255),
                    random.nextInt(255)));
        }
    }

    public Map<String, Color> getDataColors() {
        return dataColors;
    }

    public void draw() {
        float total = sum();
        float angle = 0;

        for (Map.Entry<String, Float> pair : data.entrySet()) {
            float percentage = pair.getValue() / total * PIE_MAX;

            graphics.setFill(dataColors.get(pair.getKey()));
            graphics.fillArc(x, y, width, height, angle, percentage, ArcType.ROUND);

            angle += percentage;
        }
    }

    private float sum() {
        float sum = 0;
        for (Map.Entry<String, Float> pair : data.entrySet()) {
            sum += pair.getValue();
        }
        return sum;
    }
}
