package com.cosenza.utils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class CSVReader
{

    String filepath;
    BufferedReader br;
    String csvSplitBy = ",";

    public CSVReader()
    {

    }

    public ObservableList<OHLC> Read(String filepath)
    {
        ObservableList<OHLC> DataSet = FXCollections.observableArrayList();

        String line = "";
        try
        {
            br = new BufferedReader((new FileReader(filepath)));
            while ((line = br.readLine()) != null)
            {
                //Strange Bug: If you try to print this data to console, remember toString() returns scientific notation on anything above 7 digits
                String[] values = line.split(csvSplitBy);
                ArrayList<Float> valueList = new ArrayList<Float>();
                //------------------------------Open------------------------High---------------------------Low------------------------Close----------------Date-------Time----
                OHLC data = new OHLC(Float.parseFloat(values[2]), Float.parseFloat(values[3]), Float.parseFloat(values[4]), Float.parseFloat(values[5]), values[0], values[1]);
                DataSet.add(data);

            }

        } catch (IOException e)
        {
            e.printStackTrace();
        }


        return DataSet;
    }

}
