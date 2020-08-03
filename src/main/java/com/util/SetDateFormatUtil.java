package com.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SetDateFormatUtil {
    // 获取对应日期
    public static String getDate(String day) throws ParseException {
        Date date = new Date();
        //格式日期
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        date.setDate(Integer.parseInt(day));
        return dateFormat.format(date);
    }
}
