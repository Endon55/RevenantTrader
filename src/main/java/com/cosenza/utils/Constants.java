package com.cosenza.utils;

public final class Constants
{
    public static final String WINDOW_NAME = "Revenant Trader";
    public static final int WINDOW_WIDTH = 1000;
    public static final int WINDOW_HEIGHT = 500;

    public static final float CHART_AND_CANVAS_WIDTH_PERCENT = 1.0f;
    public static final float CHART_AND_CANVAS_HEIGHT_PERCENT = 1.0f;

    public static final float AXIS_THICKNESS_PERCENT = .05f;
    public static final int PRICE_AXIS_THICKNESS_PIXELS = 70;
    public static final int TIME_AXIS_THICKNESS_PIXELS = 35;
    public static final float AXIS_HEIGHT_PERCENT = 1.0f - AXIS_THICKNESS_PERCENT * 2;

    public static final int PIXEL_BUFFER_PRICE_AXIS = 8;
    public static final int PIXELS_BETWEEN_PRICE_INCREMENTS = 30;
    public static final int DASHES_BETWEEN_INCREMENTS = 2;
    public static final int PIXELS_BETWEEN_DASHES = PIXELS_BETWEEN_PRICE_INCREMENTS / DASHES_BETWEEN_INCREMENTS;
    public static final int PIXEL_SHORT_DASH_WIDTH = 3;
    public static final int PIXEL_LONG_DASH_WIDTH = 15;


}
