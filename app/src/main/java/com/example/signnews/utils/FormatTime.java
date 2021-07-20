package com.example.signnews.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class FormatTime {
    public static String convertTime(String time){

        String[] date = time.replace("T", "-")
                .replace("Z", "-")
                .replace(":", "-")
                .split("-");

        int year_a = Integer.parseInt(date[0]);
        int month_a = Integer.parseInt(date[1]);
        int day_a = Integer.parseInt(date[2]);

        Calendar cal_a = Calendar.getInstance();
        cal_a.set(year_a,month_a,day_a);

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = df.format(cal_a.getTime());

        String cTime = formattedDate + "";
        return cTime;
    }

}
