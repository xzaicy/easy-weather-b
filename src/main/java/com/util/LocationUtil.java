package com.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LocationUtil {
    public static List getLocation() {
        List<String> list = new ArrayList<>();//储存地区的链表
        BufferedReader bufr = null;
        try {
            bufr = new BufferedReader(new FileReader(new File("D:\\location.txt")));//从文件中输入
            String line = "";
            //正则表达式
            Pattern p = Pattern.compile("\\d{2,}");
            while ((line = bufr.readLine()) != null) {
                Matcher m = p.matcher(line);
                while (m.find()) {
                    list.add(m.group());
                }
            }
        } catch (Exception e1) {
            e1.getMessage();
        }
        return list;
    }
}
