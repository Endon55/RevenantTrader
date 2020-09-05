package com.cosenza.data;

import com.cosenza.axis.Time;

public class Candlestick
{
    OHLC ohlc;

    public OHLC getOHLC()
    {
        return ohlc;
    }

    public void setOHLC(OHLC ohlc)
    {
        this.ohlc = ohlc;
    }

    public Time getTime()
    {
        return time;
    }

    public void setTime(Time time)
    {
        this.time = time;
    }

    Time time;

    public Candlestick()
    {

    }

}
