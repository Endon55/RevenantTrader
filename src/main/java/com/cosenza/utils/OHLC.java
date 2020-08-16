package com.cosenza.utils;

import java.time.LocalDateTime;

public class OHLC
{

    private float open;
    private float high;
    private float low;
    private float close;
    private String date;
    private String time;

    public OHLC(float open, float high, float low, float close, String date, String time)
    {
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.date = date;
        this.time = time;
    }

    public float getAverage()
    {
        return (open + high + low + close) / 4;
    }

    public float getOpen()
    {
        return open;
    }

    public void setOpen(float open)
    {
        this.open = open;
    }

    public float getHigh()
    {
        return high;
    }

    public void setHigh(float high)
    {
        this.high = high;
    }

    public float getLow()
    {
        return low;
    }

    public void setLow(float low)
    {
        this.low = low;
    }

    public float getClose()
    {
        return close;
    }

    public void setClose(float close)
    {
        this.close = close;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public String getTime()
    {
        return time;
    }

    public void setTime(String time)
    {
        this.time = time;
    }

}
