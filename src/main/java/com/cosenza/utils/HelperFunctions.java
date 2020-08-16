package com.cosenza.utils;

import javafx.geometry.Bounds;

public class HelperFunctions
{




    public static void printBounds(Bounds bounds)
    {
        System.out.println("Top Left, X:" + bounds.getMinX() + ", Y:" + bounds.getMinY() + ", Bottom Right, X:" + bounds.getMaxX() + ", Y:" + bounds.getMaxY());
    }
}
