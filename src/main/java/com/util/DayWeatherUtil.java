package com.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Iterator;

public class DayWeatherUtil {
    static int i = 0;
    public static void parseDWeather(){
        Iterator<String> it = LocationUtil.getLocation().iterator();
        String bm = "";
        while (it.hasNext()){
            bm = it.next();
            String url = "http://www.weather.com.cn/weather1d/" + bm + ".shtml";//网页地址
            try {
                Document doc = Jsoup.connect(url).get();
                Elements elements = doc.getElementsByAttributeValue("id","today");
                System.out.println(elements);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        parseDWeather();
    }
}
