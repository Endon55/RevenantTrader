package com.cosenza.axis;

import com.cosenza.utils.Constants;
import com.cosenza.utils.enums.AxisType;
import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.text.DecimalFormat;

public class PriceAxis extends Axis
{
    float upperBound;
    float lowerBound;
    float valueOfIncrements;
    int highestPriceCoordinate;

    public PriceAxis(float upperBound, float lowerBound, Canvas canvas)
    {
        super(canvas, AxisType.VERTICAL);
        this.upperBound = upperBound;
        this.lowerBound = lowerBound;

        //numberOfIncrements = (int)(canvas.getHeight() - Constants.PIXEL_BUFFER_PRICE_AXIS) / Constants.PIXELS_BETWEEN_PRICE_INCREMENTS;
        valueOfIncrements = (upperBound - lowerBound) / numberOfIncrements;

    }

    public int getCoordinate(float price)
    {

        return 0;
    }

    public void drawNumbers(GraphicsContext graphicsContext)
    {
        /*
         * Starts at the bottom of the canvas and decrements the pixel coordinates and increments the price. Top left of canvas is 0.
         * */
        float number = lowerBound;
        //
        int verticalCoordinate = (int)(canvas.getHeight() - Constants.PIXEL_BUFFER_PRICE_AXIS);
        graphicsContext.setTextBaseline(VPos.CENTER);

        DecimalFormat decimalFormat = new DecimalFormat("##.00000");
        for (int i = 0; i < numberOfIncrements; i++)
        {
            String text = decimalFormat.format(number);
            //System.out.println(text);
            graphicsContext.strokeText(text, 5, verticalCoordinate);
            verticalCoordinate -= Constants.PIXELS_BETWEEN_PRICE_INCREMENTS;
            number += valueOfIncrements;
        }
        highestPriceCoordinate = verticalCoordinate;

    }
    public void draw()
    {
        drawNumbers(canvas.getGraphicsContext2D());
        drawHashes (canvas.getGraphicsContext2D());
    }
    public void drawHashes(GraphicsContext graphicsContext)
    {
        int verticalCoordinate = (int)(canvas.getHeight() - Constants.PIXEL_BUFFER_PRICE_AXIS);
        for (int i = 0; i < numberOfIncrements * Constants.DASHES_BETWEEN_PRICE_INCREMENTS; i++)
        {
            if(i % 2 == 1) graphicsContext.strokeLine(0, verticalCoordinate, Constants.PIXEL_LONG_PRICE_DASH_WIDTH, verticalCoordinate);
            else graphicsContext.strokeLine(0, verticalCoordinate, Constants.PIXEL_SHORT_PRICE_DASH_WIDTH, verticalCoordinate);
            verticalCoordinate -= Constants.PIXELS_BETWEEN_PRICE_DASHES;

        }
    }

    public int getYCoordinates(float price)
    {
        if(price > upperBound && price < lowerBound) throw new IndexOutOfBoundsException();

        //Calculates percent-wise where the price should fall between the bounds
        float pricePercentageOnCanvas = (price - lowerBound) / (upperBound - lowerBound);

        //Gets the canvas height and gets the amount of pixels of drawable space between the buffers on top and bottom.
        double workingNumberOfPixels = canvas.getHeight() - Constants.PIXEL_BUFFER_PRICE_AXIS - highestPriceCoordinate;

        //Calculates where our percentage lines up on the number of pixels and normalizes the coordinates.
        return (int)(workingNumberOfPixels * price) + highestPriceCoordinate;

    }

}
