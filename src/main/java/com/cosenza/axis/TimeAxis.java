package com.cosenza.axis;

import com.cosenza.data.Time;
import com.cosenza.utils.Constants;
import com.cosenza.utils.enums.AxisType;
import com.cosenza.utils.enums.Timeframe;
import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;


import java.text.DecimalFormat;

public class TimeAxis extends Axis
{
    Timeframe timeframe;
    Time baseTimeObject;
    Time changeableTimeObject;
    int maxHorizontalCoordinate;


    public TimeAxis(Timeframe timeframe, Time mostRecentTime, AxisType axisType, Canvas canvas)
    {
        super(canvas, axisType);

        this.baseTimeObject = mostRecentTime;
        changeableTimeObject = new Time(baseTimeObject.secondsSinceEpoch());
        this.timeframe = timeframe;
        changeableTimeObject.roundToTimeframe(Timeframe.HOUR);

        maxHorizontalCoordinate = (int)(canvas.getWidth() - Constants.PIXEL_BUFFER_TIME_AXIS - canvas.getWidth() * Constants.AXIS_THICKNESS_PERCENT);
    }

    public void draw()
    {
        drawDateTime(canvas.getGraphicsContext2D());
        drawHashes(canvas.getGraphicsContext2D());
    }

    public void drawDateTime(GraphicsContext graphicsContext)
    {
        int horizontalCoordinate = maxHorizontalCoordinate;
        System.out.println("Hoz Cod: " + horizontalCoordinate);
        System.out.println(changeableTimeObject.formattedAxisString());
        graphicsContext.setTextBaseline(VPos.CENTER);


        for (int i = 0; i < numberOfIncrements; i++)
        {
            graphicsContext.strokeText(changeableTimeObject.formattedAxisString(), horizontalCoordinate, 8);
            changeableTimeObject.changeTimeSubtractTimeframe(timeframe);
            horizontalCoordinate -= Constants.PIXELS_BETWEEN_TIME_INCREMENTS;
            //number += valueOfIncrements;
        }
    }

    public void drawHashes(GraphicsContext graphicsContext)
    {
        int horizontalCoordinate = maxHorizontalCoordinate - 4;
        for (int i = 0; i < numberOfIncrements * Constants.DASHES_BETWEEN_TIME_INCREMENTS; i++)
        {
            graphicsContext.strokeLine(horizontalCoordinate, 0, horizontalCoordinate, 10);
            horizontalCoordinate -= Constants.PIXELS_BETWEEN_TIME_DASHES;

        }
    }
}
