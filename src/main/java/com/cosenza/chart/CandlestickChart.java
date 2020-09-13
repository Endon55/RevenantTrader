package com.cosenza.chart;

import com.cosenza.chart.axis.PriceAxis;
import com.cosenza.chart.axis.TimeAxis;
import com.cosenza.chart.axis.Time;
import com.cosenza.utils.enums.AxisType;
import com.cosenza.data.OHLC;
import com.cosenza.utils.enums.Timeframe;
import javafx.collections.ObservableList;
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


        timeAxis = new TimeAxis(Timeframe.HOUR, new Time(1598585574), AxisType.HORIZONTAL, bottomAxis.getGraphicsContext2D().getCanvas());

        priceAxis = new PriceAxis(100, 20, rightAxis.getGraphicsContext2D().getCanvas());
        priceAxis.draw();
        timeAxis.draw();

        //LocalDate ldt = new LocalDate();
        /*
        USE LocalDateTime and comparing it to the Epoch time to get a ms since epoch.
         */


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
