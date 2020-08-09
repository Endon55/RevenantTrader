package com.cosenza.charting;

import javafx.scene.chart.Axis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class OHLC extends XYChart
{
    public OHLC()
    {
        super(new NumberAxis(), new NumberAxis());

    }

    @Override
    protected void dataItemAdded(Series series, int i, Data data)
    {

    }

    @Override
    protected void dataItemRemoved(Data data, Series series)
    {

    }

    @Override
    protected void dataItemChanged(Data data)
    {

    }

    @Override
    protected void seriesAdded(Series series, int i)
    {

    }

    @Override
    protected void seriesRemoved(Series series)
    {

    }

    @Override
    protected void layoutPlotChildren()
    {

    }
}
