package com.cosenza.utils.enums;


import com.cosenza.utils.Constants;
public enum Timeframe
{
    MINUTE(Constants.SECONDS_IN_A_MINUTE),
    FIVE_MINUTES(Constants.SECONDS_IN_FIVE_MINUTES),
    FIFTEEN_MINUTES(Constants.SECONDS_IN_FIFTEEN_MINUTES),
    HOUR(Constants.SECONDS_IN_AN_HOUR),
    FOUR_HOUR(Constants.SECONDS_IN_FOUR_HOURS),
    DAY(Constants.SECONDS_IN_A_DAY),
    WEEK(Constants.SECONDS_IN_A_WEEK);

    private final int value;
    private Timeframe(int value) { this.value = value; }
    public int getValue() {return value;}
}

/*

public abstract class Timeframe
{
    int MINUTE = Constants.SECONDS_IN_A_MINUTE;
    int FIVE_MINUTES = Constants.SECONDS_IN_FIVE_MINUTES;
    int FIFTEEN_MINUTES = Constants.SECONDS_IN_FIFTEEN_MINUTES;
    int HOUR = Constants.SECONDS_IN_AN_HOUR;
    int FOUR_HOUR = Constants.SECONDS_IN_FOUR_HOURS;
    int DAY = Constants.SECONDS_IN_A_DAY;
    int WEEK = Constants.SECONDS_IN_A_WEEK;
}


}

*/
