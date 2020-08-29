package com.cosenza.axis;

import com.cosenza.utils.Constants;
import com.cosenza.utils.enums.AxisType;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Axis
{
    Canvas canvas;
    int numberOfIncrements;
    float scale;
    AxisType axisType;
    public Axis(Canvas canvas, AxisType axisType)
    {
        this.canvas = canvas;
        scale = 1;
        this.axisType = axisType;
        if(axisType      == AxisType.HORIZONTAL) numberOfIncrements = (int) (canvas.getWidth()  - Constants.PIXEL_BUFFER_TIME_AXIS)  / Constants.PIXELS_BETWEEN_TIME_INCREMENTS;
        else if(axisType == AxisType.VERTICAL)   numberOfIncrements = (int) (canvas.getHeight() - Constants.PIXEL_BUFFER_PRICE_AXIS) / Constants.PIXELS_BETWEEN_PRICE_INCREMENTS;
        System.out.println(axisType + ": " + numberOfIncrements);
    }


}
