package com.cosenza.chart;

import com.cosenza.axis.Axis;
import com.cosenza.axis.PriceAxis;
import com.cosenza.axis.TimeAxis;
import com.cosenza.utils.OHLC;
import javafx.collections.ObservableList;
import javafx.geometry.Bounds;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class CandlestickChart extends Chart
{
    Color outlineColor;
    Color fillColor;
    TimeAxis timeAxis;
    PriceAxis priceAxis;
    public CandlestickChart(int chartAndAxisWidth, int chartAndAxisHeight)
    {
        super(chartAndAxisWidth, chartAndAxisHeight);
        outlineColor = Color.RED;
        fillColor = Color.TEAL;
        timeAxis = new TimeAxis();
        priceAxis = new PriceAxis(100, 20, rightAxis.getGraphicsContext2D().getCanvas());
        priceAxis.draw();
    }

    public void drawChart(ObservableList<OHLC> dataSet)
    {
        for (int i = 0; i < dataSet.size(); i++)
        {
            
        }
    }


    /*
    I like this idea, we get the highest and lowest value of the visible data set, then draw the value axis. When we want to draw a candlestick we ask the axis what coordinates do i draw these?.



     */



}
