package com.util;

import com.pojo.Weather;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FutureWeatherUtil {
    static int i = 0;

    public static void parseFWeather() {
        Iterator<String> it = LocationUtil.getLocation().iterator();
        String bm = "";
        while (it.hasNext()) {
            bm = it.next();
            String url = "http://www.weather.com.cn/weather/" + bm + ".shtml";
            try {
                Document document = Jsoup.connect(url).get();
                Elements locElement = document.getElementsByAttributeValue("class", "con today clearfix");
                Elements liElement = locElement.select("li[class^=sky skyid lv]");
                HashMap<Integer, Weather> hash = new HashMap<>();
                ListIterator<Element> listIter = liElement.listIterator(0);
                while (listIter.hasNext()) {
                    Element e1 = listIter.next();
                    String day = e1.getElementsByTag("h1").text().split("\\D{1,2}")[0];
                    String date = SetDateFormatUtil.getDate(day);
                    String status = e1.getElementsByClass("wea").eq(0).text();
                    String tem = e1.getElementsByClass("tem").eq(0).text();
                    String windLevel = e1.select("i").eq(1).text();
                    //温度
                    String[] temArr = tem.split("\\D{1,2}");
                    // 最高气温
                    String maxTem;
                    // 最低气温
                    String minTem;
                    if (temArr.length == 2) {
                        maxTem = tem.split("\\D{1,2}")[0] + "℃";
                        minTem = tem.split("\\D{1,2}")[1] + "℃";
                    } else {
                        maxTem = tem.split("\\D{1,2}")[0] + "℃";
                        minTem = tem.split("\\D{1,2}")[0] + "℃";
                    }

                    i++;
                    //地区
                    StringBuilder sb = new StringBuilder();
                    for (Element e : locElement) {
                        Document conDoc = Jsoup.parse(e.toString());
                        Elements location = conDoc.getElementsByAttributeValue("class", "crumbs fl");
                        String loc = location.text();
                        String[] locs = loc.split(" > ");
                        for (int j = 1; j < locs.length; j++) {
                            sb.append(locs[j]);
                        }
                    }
                    Weather weather = new Weather();
                    weather.setLocation(sb.toString());
                    weather.setDate(date);
                    weather.setStatus(status);
                    weather.setMaxTem(maxTem);
                    weather.setMinTem(minTem);
                    weather.setTem(tem);
                    weather.setWindLevel(windLevel);
                    hash.put(i, weather);
                }
                Set<Integer> keys = hash.keySet();
                for (Integer key : keys) {
                    Weather value = hash.get(key);
                    Connection conn = null;
                    try {
                        PreparedStatement ps = null;
                        conn = DataUtils.getConnection();
                        String sql = "insert into futuer_weather(`location`,`date`,`status`,`max_tem`,`min_tem`,`tem`,`wind_level`) values(?,?,?,?,?,?,?)";
                        ps = conn.prepareStatement(sql);//预编译SQL，先写sql,然后不执行
                        ps.setString(1, value.getLocation());
                        ps.setString(2, value.getDate());
                        ps.setString(3, value.getStatus());
                        ps.setString(4, value.getMaxTem());
                        ps.setString(5, value.getMinTem());
                        ps.setString(6, value.getTem());
                        ps.setString(7, value.getWindLevel());
                        ps.executeUpdate();
                        conn.close();
                    } catch (SQLException e) {
                        System.out.println("数据库访问失败");
                        e.printStackTrace();
                    }
                    System.out.println(key + "," + value.toString());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception, ClassNotFoundException, SQLException {
        parseFWeather();
    }
}

