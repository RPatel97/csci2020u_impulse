package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.*;

public class Main extends Application {

    @Override public void start(Stage stage) throws Exception {
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String, Number> bc =
                new BarChart<String, Number>(xAxis, yAxis);
        bc.setTitle("Average Pricing");
        xAxis.setLabel("Average Price by year");
        yAxis.setLabel("Prices");

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Avg Housing Prices");
        series1.getData().add(new XYChart.Data("one", 247381.0));
        series1.getData().add(new XYChart.Data("two", 264171.4));
        series1.getData().add(new XYChart.Data("three", 287715.3));
        series1.getData().add(new XYChart.Data("four", 294736.1));
        series1.getData().add(new XYChart.Data("five", 308431.4));
        series1.getData().add(new XYChart.Data("six", 322635.9));
        series1.getData().add(new XYChart.Data("seven", 340253.0));
        series1.getData().add(new XYChart.Data("eight", 363153.7));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Avg Commercial Prices");
        series2.getData().add(new XYChart.Data("one", 1121585.3));
        series2.getData().add(new XYChart.Data("two", 1219479.5));
        series2.getData().add(new XYChart.Data("three", 1246354.2));
        series2.getData().add(new XYChart.Data("four", 1295364.8));
        series2.getData().add(new XYChart.Data("five", 1335932.6));
        series2.getData().add(new XYChart.Data("six", 1472362.0));
        series2.getData().add(new XYChart.Data("seven", 1583521.9));
        series2.getData().add(new XYChart.Data("eight", 1613246.3));

        bc.getData().addAll(series1, series2);

        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("18-25", 648),
                        new PieChart.Data("26-35", 1021),
                        new PieChart.Data("36-45", 2453),
                        new PieChart.Data("46-55", 3173),
                        new PieChart.Data("56-65", 1868),
                        new PieChart.Data("65+", 2247));

        final PieChart pc = new PieChart(pieChartData);
        pc.setTitle("Purchases by age groups");

        SplitPane root = FXMLLoader.load(getClass().getResource("lab06.fxml"));
        root.getItems().addAll(bc, pc);

        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Lab 06");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}