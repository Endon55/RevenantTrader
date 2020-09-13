package com.cosenza.data;

import com.cosenza.utils.enums.Timeframe;
import javafx.collections.ObservableList;

public class CandlestickData
{

    float highestPrice;
    float lowestPrice;
    Timeframe timeframe;
    CSVReader reader;

ObservableList<OHLC> dataSet;

/*
Get Highest and Lowest Price from data set
Change data structure by timeframe

 */
    public CandlestickData(Timeframe timeframe)
    {
        this.timeframe = timeframe;

    }
    
    public ObservableList<OHLC> getDataSet()
    {
        return dataSet;
    }
    public float getHighestPrice()
    {
        return highestPrice;
    }

    public float getLowestPrice()
    {
        return lowestPrice;
    }
}
