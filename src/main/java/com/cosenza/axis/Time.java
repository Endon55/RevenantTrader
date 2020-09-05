package com.cosenza.axis;

import com.cosenza.utils.Constants;
import com.cosenza.utils.enums.Months;
import com.cosenza.utils.enums.Timeframe;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class Time
{
    int year;
    private LocalDateTime localDateTime;



    public Time(int Year, int Month, int Day, int Hour, int Minute, int Second)
    {
        localDateTime = LocalDateTime.of(Year, Month, Day, Hour, Minute, Second);
    }
    public Time(long epochSeconds)
    {
        localDateTime = LocalDateTime.ofEpochSecond(epochSeconds, 0, ZoneOffset.UTC);
    }
/*    public Time(String Date, String Time)
    {
        CharSequence sequence = CharSequence.
        localDateTime = LocalDateTime. parse()
    }*/


    public void changeTimeWithNewEpoch(long epochSeconds)
    {
        localDateTime = LocalDateTime.ofEpochSecond(epochSeconds, 0, ZoneOffset.UTC);
    }
    public void changeTimeSubtractTimeframe(Timeframe timeframe)
    {

        localDateTime = LocalDateTime.ofEpochSecond(secondsSinceEpoch() - timeframe.getValue() * Constants.INCREMENTS_BETWEEN_TIME_UNITS, 0, ZoneOffset.UTC);
    }

    public void roundToTimeframe(Timeframe timeframe)
    {
        long epochSeconds = secondsSinceEpoch();
        long remainder = epochSeconds % timeframe.getValue();

        changeTimeWithNewEpoch(epochSeconds - remainder);
    }

    public long secondsSinceEpoch()
    {
        return localDateTime.toEpochSecond(ZoneOffset.UTC);
    }

    public int getMonth()
    {
        return localDateTime.getMonth().getValue();
    }

    public int getDay()
    {
        return localDateTime.getDayOfMonth();
    }

    public int getHour()
    {
        return localDateTime.getHour();
    }

    public int getSecond()
    {
        return localDateTime.getSecond();
    }


    public static String formattedAxisString(long timeInSecondsSinceEpoch)
    {
        LocalDateTime ldt = LocalDateTime.ofEpochSecond(timeInSecondsSinceEpoch, 0, ZoneOffset.UTC);
        return ldt.getDayOfMonth() + " " + Months.monthsShort[ldt.getMonthValue()] + " " + String.format("%02d", ldt.getHour()) + ":" + String.format("%02d", ldt.getMinute());
        //ldt.getMonth().toString().toLowerCase()
    }
    public String formattedAxisString()
    {
        return formattedAxisString(secondsSinceEpoch());
    }

    public static long roundLongToTimeframe(long secondsSinceEpoch, Timeframe timeframe)
    {
        return secondsSinceEpoch - (secondsSinceEpoch % timeframe.getValue());
    }

}
