package com.cosenza.chart.axis;

import com.cosenza.utils.Constants;
import com.cosenza.utils.enums.AxisType;
import com.cosenza.utils.enums.Timeframe;
import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;


import static com.cosenza.utils.Constants.PIXELS_BETWEEN_TIME_INCREMENTS;

public class TimeAxis extends Axis
{

    Timeframe timeframe;
    Time newestTimeObject;
    int maxHorizontalCoordinate;

    long oldestTimeEpoch;
    long newestTimeEpoch;

    public TimeAxis(Timeframe timeframe, Time mostRecentTime, AxisType axisType, Canvas canvas)
    {
        super(canvas, axisType);

        //Intentionally not rounded so as to not lose data
        this.newestTimeObject = mostRecentTime;
        //changeableTimeObject = new Time(newestTimeObject.secondsSinceEpoch());

        this.timeframe = timeframe;
        //changeableTimeObject.roundToTimeframe(Timeframe.HOUR);

        maxHorizontalCoordinate = (int)(canvas.getWidth() - Constants.PIXEL_BUFFER_TIME_AXIS - canvas.getWidth() * Constants.AXIS_THICKNESS_PERCENT);

        newestTimeEpoch = mostRecentTime.secondsSinceEpoch();
        oldestTimeEpoch = newestTimeEpoch - numberOfIncrements * Timeframe.HOUR.getValue();
        System.out.println(newestTimeObject.secondsSinceEpoch()-Timeframe.MINUTE.getValue());
    }

    public void draw()
    {
        drawDateTime(canvas.getGraphicsContext2D());
        drawHashes(canvas.getGraphicsContext2D());
    }

    public void drawDateTime(GraphicsContext graphicsContext)
    {
        long iterableEpochTime = Time.roundLongToTimeframe(newestTimeEpoch, timeframe);
        int horizontalCoordinate = maxHorizontalCoordinate;
        graphicsContext.setTextBaseline(VPos.CENTER);

        for (int i = 0; i < numberOfIncrements; i++)
        {
            graphicsContext.strokeText(Time.formattedAxisString(iterableEpochTime), horizontalCoordinate, 8);
            iterableEpochTime -= timeframe.getValue();
            horizontalCoordinate -= PIXELS_BETWEEN_TIME_INCREMENTS;
        }
    }

    public void drawHashes(GraphicsContext graphicsContext)
    {
        int horizontalCoordinate = (int)(canvas.getWidth() - canvas.getWidth() * Constants.AXIS_THICKNESS_PERCENT) - 4;
        //int horizontalCoordinate = maxHorizontalCoordinate - 4;
        for (int i = 0; i < numberOfIncrements * Constants.DASHES_BETWEEN_TIME_INCREMENTS; i++)
        {
            graphicsContext.strokeLine(horizontalCoordinate, 0, horizontalCoordinate, 10);
            horizontalCoordinate -= Constants.PIXELS_BETWEEN_TIME_DASHES;

        }
    }
    public int getCandlestickCoordinatesX(Time time)
    {

        long timeSinceEpoch = Time.roundLongToTimeframe(time.secondsSinceEpoch(), timeframe);

        if(timeSinceEpoch < newestTimeEpoch && timeSinceEpoch > oldestTimeEpoch) {

            //Calculates percent-wise where the price should fall between the bounds
            float timePercentageOnCanvas = (float) (timeSinceEpoch - oldestTimeEpoch) / (float) (newestTimeEpoch - oldestTimeEpoch);

            //Gets the canvas height and gets the amount of pixels of drawable space between the buffers on top and bottom.
            double workingNumberOfPixels = canvas.getHeight() - Constants.PIXEL_BUFFER_TIME_AXIS - maxHorizontalCoordinate;

            //Calculates where our percentage lines up on the number of pixels and normalizes the coordinates.
            return (int) (workingNumberOfPixels * timePercentageOnCanvas) + maxHorizontalCoordinate;

        }
        else throw new IndexOutOfBoundsException();

      }
}
