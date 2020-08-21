package com.cosenza.axis;

import com.cosenza.utils.Constants;
import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.text.DecimalFormat;

public class PriceAxis extends Axis
{
    float upperBound;
    float lowerBound;
    Canvas canvas;
    float scale;
    int increments;
    float valueIncrements;

    public PriceAxis(float upperBound, float lowerBound, Canvas canvas)
    {
        this.upperBound = upperBound;
        this.lowerBound = lowerBound;
        this.canvas = canvas;
        scale = 1;
        increments = (int)(canvas.getHeight() - Constants.PIXEL_BUFFER_PRICE_AXIS) / Constants.PIXELS_BETWEEN_PRICE_INCREMENTS;
        valueIncrements = (upperBound - lowerBound) / increments;
    }

    public int getCoordinate(float price)
    {

        return 0;
    }

    public void updateScaling()
    {

    }

    public void draw()
    {
        //Math out pixel coordinates
        //Draw Numbers
        //Draw Hashes next to numbers
        //Math out sub increment hashes
        //Draw Sub Hashes




        drawNumber(canvas.getGraphicsContext2D());
        drawHashes(canvas.getGraphicsContext2D());

    }
    private void drawNumber(GraphicsContext graphicsContext)
    {
        float number = lowerBound;
        int verticalCoordinate = (int)(canvas.getHeight() - Constants.PIXEL_BUFFER_PRICE_AXIS);
        graphicsContext.setTextBaseline(VPos.CENTER);

        DecimalFormat decimalFormat = new DecimalFormat("##.00000");
        for (int i = 0; i < increments; i++)
        {
            String text = decimalFormat.format(number);
            System.out.println(text);
            graphicsContext.strokeText(text, 5, verticalCoordinate);
            verticalCoordinate -= Constants.PIXELS_BETWEEN_PRICE_INCREMENTS;
            number += valueIncrements;
        }
    }
    private void drawHashes(GraphicsContext graphicsContext)
    {
        int verticalCoordinate = (int)(canvas.getHeight() - Constants.PIXEL_BUFFER_PRICE_AXIS);

        //graphicsContext.getFontSmoothingType();


        for (int i = 0; i < increments * Constants.DASHES_BETWEEN_INCREMENTS; i++)
        {
            if(i % 2 == 1) graphicsContext.strokeLine(0, verticalCoordinate, Constants.PIXEL_LONG_DASH_WIDTH, verticalCoordinate);
            else graphicsContext.strokeLine(0, verticalCoordinate, Constants.PIXEL_SHORT_DASH_WIDTH, verticalCoordinate);
            verticalCoordinate -= Constants.PIXELS_BETWEEN_DASHES;

        }
    }

}
