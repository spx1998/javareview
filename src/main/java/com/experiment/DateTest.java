package com.experiment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateTest {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = dateFormat.format(date);
        Date parse = dateFormat.parse(format);
        System.out.println(parse);
    }
}
