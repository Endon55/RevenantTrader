package com.cosenza.utils;

import com.cosenza.charting.OHLC;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader
{

    String filepath;
    BufferedReader br;
    String csvSplitBy = ",";

    public CSVReader()
    {

    }

    public ArrayList<ArrayList<Float>> Read(String filepath)
    {
        ArrayList<ArrayList<Float>> data = new ArrayList<ArrayList<Float>>();
        String line = "";
        try
        {
            br = new BufferedReader((new FileReader(filepath)));
            while ((line = br.readLine()) != null)
            {
                //Strange Bug: If you try to print this data to console, remember toString() returns scientific notation on anything above 7 digits
                String[] values = line.split(csvSplitBy);
                ArrayList<Float> valueList = new ArrayList<Float>();

                //Converts 2019.01.01 to 20190101
                valueList.add(Float.parseFloat(values[0].replace(".", "")));
                //Converts Time 17:50 to 17.50
                valueList.add(Float.parseFloat(values[1].replace(":", ".")));
                //Minute  Open Value
                valueList.add(Float.parseFloat(values[2]));
                //Minute  High Value
                valueList.add(Float.parseFloat(values[3]));
                //Minute   Low Value
                valueList.add(Float.parseFloat(values[4]));
                //Minute Close Value
                valueList.add(Float.parseFloat(values[5]));
                data.add(valueList);
            }

        } catch (IOException e)
        {
            e.printStackTrace();
        }


        return data;
    }

}
