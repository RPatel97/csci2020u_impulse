package lab07;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Canvas canvas = new Canvas();
        canvas.widthProperty().bind(primaryStage.widthProperty());
        canvas.heightProperty().bind(primaryStage.heightProperty());

        Group root = new Group();
        root.getChildren().add(canvas);

        primaryStage.setTitle("Lab07");
        primaryStage.setScene(new Scene(root, 450, 270));
        primaryStage.show();

        // Create graphics context
        GraphicsContext graphics = canvas.getGraphicsContext2D();
        graphics.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        // Data
        Map<String, Float> data = new TreeMap<>();

        // Read file
        FileReader fileReader = new FileReader("weatherwarnings-2015.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            String[] splitLine = line.split(",");
            if (splitLine.length >= 6) {
                String type = splitLine[5];
                if (data.containsKey(type)) {
                    data.put(type, data.get(type) + 1.0f);
                } else {
                    data.put(type, 1.0f);
                }
            }
        }

        // Draw
        PieChart chart = new PieChart(graphics, 10, 10, 250, 250);
        chart.setData(data);
        chart.draw();

        PieChartLegend legend = new PieChartLegend(graphics, 280, 10, 250, 63 * data.size(), 10, "Arial");
        legend.setChart(chart);
        legend.draw();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
