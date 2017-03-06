package lab07;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.Map;

public class PieChartLegend {
    private GraphicsContext graphics;
    private PieChart chart;
    private int x;
    private int y;
    private int width;
    private int height;
    private int padding;
    private String font;

    public PieChartLegend(GraphicsContext graphics, int x, int y, int width, int height, int padding, String font) {
        this.graphics = graphics;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.padding = padding;
        this.font = font;
    }

    public PieChart getChart() {
        return chart;
    }

    public void setChart(PieChart chart) {
        this.chart = chart;
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

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }

    public void draw() {
        Map<String, Color> dataColors = chart.getDataColors();

        // Calculate heights
        float itemHeight = (height / dataColors.size()) - (padding * dataColors.size());
        float itemWidth = (width / dataColors.size()) - (padding * dataColors.size());

        float currentY = 0;
        for (Map.Entry<String, Color> pair : dataColors.entrySet()) {
            graphics.setFill(pair.getValue());
            graphics.fillRect(x, y + currentY * (itemHeight + padding), itemWidth, itemHeight);
            graphics.setFont(Font.font(font, itemHeight / 3));
            graphics.fillText(pair.getKey(), x + itemWidth + padding,
                    y + itemHeight / 2 + currentY * (itemHeight + padding));
            currentY++;
        }
    }
}
