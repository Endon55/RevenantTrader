package com.cosenza.chart;

import com.cosenza.utils.Constants;
import com.cosenza.utils.HelperFunctions;
import javafx.geometry.Bounds;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

public class Chart
{

    int assignedWidth;
    int assignedHeight;
    boolean debug;

    BorderPane chartPane;

    private Canvas leftAxis;
    private Canvas topAxis;
    Canvas bottomAxis;
    Canvas rightAxis;
    Canvas centerArea;

    public Chart(int chartAndAxisWidth, int chartAndAxisHeight)
    {
        assignedWidth = chartAndAxisWidth;
        assignedHeight = chartAndAxisHeight;
        debug = false;

        //Will potentially add this functionality later
        topAxis = new Canvas(0,0);
        leftAxis = new Canvas(0,0);

        bottomAxis = new Canvas();
        rightAxis = new Canvas();
        centerArea = new Canvas();

        //chartPane.setMaxWidth(assignedWidth);
        //chartPane.setMaxHeight(assignedHeight);

        //int verticalAxisThickness = (int)(Constants.AXIS_THICKNESS_PIXELS * assignedWidth);
        int CenterWidth = assignedWidth - Constants.PRICE_AXIS_THICKNESS_PIXELS;

        //int horizontalAxisThickness = (int)(Constants.AXIS_THICKNESS_PIXELS * assignedHeight);
        int CenterHeight = assignedHeight - Constants.PRICE_AXIS_THICKNESS_PIXELS;

        rightAxis.setWidth(Constants.PRICE_AXIS_THICKNESS_PIXELS);
        rightAxis.setHeight(CenterHeight);

        System.out.println(Constants.PRICE_AXIS_THICKNESS_PIXELS);
        bottomAxis.setHeight(Constants.PRICE_AXIS_THICKNESS_PIXELS);
        bottomAxis.setWidth(assignedWidth);

        centerArea.setWidth(CenterWidth);
        centerArea.setHeight(CenterHeight);

        chartPane = new BorderPane(centerArea, topAxis, rightAxis, bottomAxis, leftAxis);
    }

    protected void debugDraw()
    {
        System.out.println("Right Axis");
        drawBounds(rightAxis.getGraphicsContext2D(), rightAxis.getBoundsInParent());
        System.out.println("Bottom Axis");
        drawBounds(bottomAxis.getGraphicsContext2D(), bottomAxis.getBoundsInParent());
        System.out.println("Center");
        drawBounds(centerArea.getGraphicsContext2D(), centerArea.getBoundsInParent());

    }

    private void drawBounds(GraphicsContext gc, Bounds bound)
    {
        gc.setStroke(Color.GREEN);
        gc.strokeRect(bound.getMinX(), bound.getMinY(), bound.getWidth(), bound.getHeight());

        HelperFunctions.printBounds(bound);
    }

    public void debug(boolean debug)
    {
        if(debug)
        {
            this.debug = true;
            debugDraw();
        }
        if(!debug) this.debug = false;
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
