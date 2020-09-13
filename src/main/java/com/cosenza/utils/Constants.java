package com.cosenza.utils;

import com.oanda.v20.primitives.InstrumentName;
import com.oanda.v20.account.AccountID;

public final class Constants
{
    //Oanda Related Constants
    public static final AccountID  ACCOUNT_ID = new AccountID("101-001-10809598-005");
    public static final String URL = "https://api-fxpractice.oanda.com";
    public static final String TOKEN = "f508663a3098c2b27f3087a0d9e921e2-266fe6172c4446a0dafb662a713dead9";
    public static final InstrumentName INSTRUMENT = new InstrumentName("EUR_USD");

    //Window initialization
    public static final String WINDOW_NAME = "Revenant Trader";
    public static final int WINDOW_WIDTH = 1000;
    public static final int WINDOW_HEIGHT = 500;
    //How much of the assigned window area the axis panels are allowed to take up
    public static final float CHART_AND_CANVAS_WIDTH_PERCENT = 1.0f;
    public static final float CHART_AND_CANVAS_HEIGHT_PERCENT = 1.0f;
    //The thickness they're assigned+
    public static final float AXIS_THICKNESS_PERCENT = .05f;
    public static final int PRICE_AXIS_THICKNESS_PIXELS = 70;
    public static final int TIME_AXIS_THICKNESS_PIXELS = 20;
    public static final float AXIS_HEIGHT_PERCENT = 1.0f - AXIS_THICKNESS_PERCENT * 2;

    //Price Axis formatting constants
    public static final int PIXEL_BUFFER_PRICE_AXIS = 8;
    public static final int PIXELS_BETWEEN_PRICE_INCREMENTS = 30;
    public static final int DASHES_BETWEEN_PRICE_INCREMENTS = 2;
    public static final int PIXELS_BETWEEN_PRICE_DASHES = PIXELS_BETWEEN_PRICE_INCREMENTS / DASHES_BETWEEN_PRICE_INCREMENTS;
    public static final int PIXEL_SHORT_PRICE_DASH_WIDTH = 3;
    public static final int PIXEL_LONG_PRICE_DASH_WIDTH = 15;

    //Time Axis formatting Constants
    public static final int PIXEL_BUFFER_TIME_AXIS = 100;
    public static final int PIXELS_BETWEEN_TIME_INCREMENTS = 80;
    public static final int DASHES_BETWEEN_TIME_INCREMENTS = 1;
    public static final int PIXELS_BETWEEN_TIME_DASHES = PIXELS_BETWEEN_TIME_INCREMENTS / DASHES_BETWEEN_TIME_INCREMENTS;
    public static final int INCREMENTS_BETWEEN_TIME_UNITS = 5;
    public static final int PIXELS_BUFFER_BETWEEN_CANDLESTICKS = 2;
    public static final int CANDLESTICKS_BETWEEN_TIME_INCREMENTS = 4;



    //Candlestick Constants






    //Seconds in various timeframes
    public static final int SECONDS_IN_A_MINUTE = 60;
    public static final int SECONDS_IN_FIVE_MINUTES = SECONDS_IN_A_MINUTE * 5;
    public static final int SECONDS_IN_FIFTEEN_MINUTES = SECONDS_IN_FIVE_MINUTES * 3;
    public static final int SECONDS_IN_AN_HOUR = SECONDS_IN_FIFTEEN_MINUTES * 4;
    public static final int SECONDS_IN_FOUR_HOURS = SECONDS_IN_AN_HOUR * 4;
    public static final int SECONDS_IN_A_DAY = SECONDS_IN_FOUR_HOURS * 6;
    public static final int SECONDS_IN_A_WEEK = SECONDS_IN_A_DAY * 7;





}
