package com.cosenza;

import com.cosenza.chart.CandlestickChart;
import com.cosenza.utils.CSVReader;
import com.cosenza.utils.Constants;
import com.cosenza.data.OHLC;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/*
    Current thoughts are i need to use extends Region or Chart. Probably region will give me the most flexibility and maybe performance but ill need to dig deeper.
    Potentially using a webview and javascript to accomplish the charting


    Ok we may have solved it boys. https://github.com/GSI-CS-CO/chart-fx
    This sight has a library doing exactly what we want, Im not interested in using their work past being reference material.
    So it appears they actually just draw onto the screen normally, theres no tricks.
    Canvas has a GraphicsContext built in so now we figure out the efficient way to draw potentially thousands of rectangles and lines.

 */

public class Main extends Application
{

    //private static Scene scene;
    private ObservableList<OHLC> DataSet;
    private float currentLowest;
    private float currentHighest;

    @Override
    public void start(Stage stage)
    {
        loadData();
        stage.setTitle(Constants.WINDOW_NAME);
        stage.getIcons().add(new Image("file:" + System.getProperty("user.dir") + "/src/main/resources/com/cosenza/icon2.png"));

        Scene scene = new Scene(new Group(), Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);

        CandlestickChart chart = new CandlestickChart(
                (int)(Constants.WINDOW_WIDTH  * Constants.CHART_AND_CANVAS_WIDTH_PERCENT),
                (int)(Constants.WINDOW_HEIGHT * Constants.CHART_AND_CANVAS_HEIGHT_PERCENT));



        chart.debug(true);


        ((Group) scene.getRoot()).getChildren().add(chart.getChartPane());

        stage.setScene(scene);
        stage.show();
    }


    public XYChart.Series csvDataToSeries(ObservableList<OHLC> DataSet)
    {
        int index = 0;
        float lowest = DataSet.get(0).getAverage();
        float highest = lowest;
        XYChart.Series sr = new XYChart.Series();

        for (OHLC data : DataSet)
        {
            float average = data.getAverage();
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

        DataSet = reader.Read(userDirectory + "/src/main/resources/com/cosenza/data.csv");
    }

    public static void main(String[] args)
    {
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