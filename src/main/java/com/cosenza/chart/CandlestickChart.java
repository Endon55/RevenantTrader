package com.cosenza.chart;

import com.cosenza.utils.Constants;
import com.cosenza.utils.HelperFunctions;
import javafx.geometry.Bounds;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class CandlestickChart extends Chart
{
    int assignedWidth;
    int assignedHeight;

    boolean debug;

    public CandlestickChart(int chartAndAxisWidth, int chartAndAxisHeight)
    {
        assignedWidth = chartAndAxisWidth;
        assignedHeight = chartAndAxisHeight;
        setCanvasAreas();
        debug = false;
    }

    public void draw()
    {
        GraphicsContext gc = rightAxis.getGraphicsContext2D();
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);
        gc.strokeRect(1, 1, 100, 100);
        gc.fillOval(60, 60, 30, 30);
    }

    private void setCanvasAreas()
    {
        chartPane.setMaxWidth(assignedWidth);
        chartPane.setMaxHeight(assignedHeight);


        //int verticalAxisThickness = (int)(Constants.AXIS_THICKNESS_PIXELS * assignedWidth);
        int CenterWidth = assignedWidth - Constants.AXIS_THICKNESS_PIXELS;

        //int horizontalAxisThickness = (int)(Constants.AXIS_THICKNESS_PIXELS * assignedHeight);
        int CenterHeight = assignedHeight - Constants.AXIS_THICKNESS_PIXELS;



        rightAxis.setWidth(Constants.AXIS_THICKNESS_PIXELS);
        rightAxis.setHeight(CenterHeight);

        System.out.println(Constants.AXIS_THICKNESS_PIXELS);
        bottomAxis.setHeight(Constants.AXIS_THICKNESS_PIXELS);
        bottomAxis.setWidth(assignedWidth);

        centerArea.setWidth(CenterWidth);
        centerArea.setHeight(CenterHeight);
    }

    private void debugDraw()
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
}
