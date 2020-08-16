package com.cosenza.chart;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;

public class Chart
{

    BorderPane chartPane;

    Canvas leftAxis;
    Canvas bottomAxis;
    Canvas rightAxis;
    Canvas topAxis;
    Canvas centerArea;

    public Chart()
    {
        //Will potentially add this functionality later
        topAxis = new Canvas(0,0);
        leftAxis = new Canvas(0,0);


        bottomAxis = new Canvas();
        rightAxis = new Canvas();
        centerArea = new Canvas();

        chartPane = new BorderPane(centerArea, topAxis, rightAxis, bottomAxis, leftAxis);


/*        chartPane.autosize();
        chartPane.getContentBias();


        //chartPane.setTop(topAxis);
        chartPane.setLeft(leftAxis);

        chartPane.setBottom(bottomAxis);
        chartPane.setRight(rightAxis);
        //chartPane.setCenter(centerArea);

    */

    }

    public BorderPane getChartPane()
    {
        return chartPane;
    }

    public Canvas getRightAxis()
    {
        return rightAxis;
    }

    public Canvas getBottomAxis()
    {
        return bottomAxis;
    }

    public Canvas getCenterArea()
    {
        return centerArea;
    }



}
