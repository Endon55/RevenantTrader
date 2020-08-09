package com.cosenza;
import com.cosenza.charting.OHLC;
import com.cosenza.utils.CSVReader;
import com.cosenza.utils.Constants;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.Axis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.ArrayList;



public class Main extends Application
{

    //private static Scene scene;
    private ArrayList<ArrayList<Float>> data;
    private float currentLowest;
    private float currentHighest;

    @Override
    public void start(Stage stage)
    {
        loadData();
        stage.setTitle(Constants.WINDOW_NAME);
        Scene scene = new Scene(new Group(), Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);


        //final OHLC chart1 = new OHLC();

        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();



        final LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);

        lineChart.getData().add(csvDataToSeries(data));
        yAxis.setAutoRanging(false);
        yAxis.setUpperBound(currentHighest);
        yAxis.setLowerBound(currentLowest);

        ((Group) scene.getRoot()).getChildren().add(lineChart);

        stage.setScene(scene);
        stage.show();

    }


    public XYChart.Series csvDataToSeries(ArrayList<ArrayList<Float>> data)
    {
        int index = 0;
        float lowest = (data.get(0).get(2) + data.get(0).get(3) + data.get(0).get(4) + data.get(0).get(5)) / 4;
        float highest = lowest;
        XYChart.Series sr = new XYChart.Series();

        for (ArrayList<Float> line : data)
        {
            float average = (line.get(2) + line.get(3) + line.get(4) + line.get(5)) / 4;
            System.out.println("Average: " + average);
            sr.getData().add(new XYChart.Data(index++, average));

            if(average > highest) highest = average;
            if(average < lowest) lowest = average;
        }
        currentHighest = highest;
        currentLowest = lowest;
        return sr;
    }

    public void loadData()
    {
        CSVReader reader = new CSVReader();
        String userDirectory = System.getProperty("user.dir");
        System.out.println("User Dir: " + userDirectory);

        data = reader.Read(userDirectory + "/src/main/resources/com/cosenza/data.csv");
        for (ArrayList<Float> list :
                data)
        {
            for (Float dataPoint :
                    list)
            {
                Float temp = dataPoint;
                //System.out.println(String.format("%f", temp) + " ");
            }
            //System.out.println();
        }
    }

    public static void main(String[] args)
    {
        CSVReader reader = new CSVReader();

        //loadData();


        launch();
        System.out.println("hello world");
    }

}




/*
        Context ctx = new Context(
                "https://api-fxpractice.oanda.com",
                "f508663a3098c2b27f3087a0d9e921e2-266fe6172c4446a0dafb662a713dead9");

        try {
            AccountSummary summary = ctx.account.summary(
                    new AccountID("101-001-10809598-005")).getAccount();
            System.out.println(summary);
        } catch (Exception e) {
            e.printStackTrace();
        }

 */

/*
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(main.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

 */