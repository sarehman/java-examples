package org.example;

import java.text.NumberFormat;

public class To24HoursExample {

    public static void main(String[] args){
        System.out.println(convert("12:00:00AM"));
    }

    public static String convert(String s){
        boolean isAm = s.substring(8).equals("AM") ? true : false;
        int hour = Integer.parseInt(s.substring(0, 2));
        if(isAm){

            System.out.println(hour);
            if(hour == 12){
                hour = 0;
            }
        }else{
           if(hour >= 1 && hour < 12){
               hour = hour + 12;
           }
        }
        String hr = String.format("%02d", hour);
        s = hr+s.substring(2, 8);
        return s;
    }
}
