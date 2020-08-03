package com.util;

import com.pojo.Lives;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LivesUtil {
    static int i = 0;

    public static void parseLives() {
        Iterator<String> it = LocationUtil.getLocation().iterator();
        String bm = "";//城市
        while (it.hasNext()) {
            bm = it.next();
            String url = "http://www.weather.com.cn/weather1d/" + bm + ".shtml";//网页地址
            try {
                Document doc = Jsoup.connect(url).get();
                Elements elements = doc.getElementsByAttributeValue("class", "livezs");//获取livezs标签下的html内容
                Elements locElement = doc.getElementsByAttributeValue("class", "ctop clearfix");//获取ctop clearfix标签下的html内容
                HashMap<Integer, Lives> liveHash = new HashMap<>();//创建一个哈希表储存数据
                ListIterator<Element> listIter = elements.listIterator(0);//迭代器
                while (listIter.hasNext()) {
                    Element e1 = listIter.next();
                    String sunstroke = e1.getElementsByAttributeValue("class", "li1 picc hot").select("p").eq(0).text();
                    String lose = e1.getElementsByAttributeValue("class", "li2 hot").select("p").eq(0).text();
                    String blood = e1.getElementsByAttributeValue("class", "li5 hot").select("p").eq(0).text();
                    String dress = e1.getElementsByAttributeValue("class", "li3 hot").select("p").eq(0).text();
                    String car = e1.getElementsByAttributeValue("class", "li4 hot").select("p").eq(0).text();
                    String ultraviolet = e1.getElementsByAttributeValue("class", "li1 hot").select("p").eq(0).text();

                    i++;//每获取一个城市的数据就加一次
                    //地区
                    StringBuilder sb = new StringBuilder();//存储地区
                    for (Element e : locElement) {
                        Document conDoc = Jsoup.parse(e.toString());
                        Elements location = conDoc.getElementsByAttributeValue("class", "crumbs fl");
                        String loc = location.text();
                        String[] locs = loc.split(" > ");//以>为分割符
                        for (int j = 1; j < locs.length; j++) {
                            sb.append(locs[j]);
                        }
                    }
                    Lives lives = new Lives();//创建对象，实例化
                    lives.setLocation(sb.toString());
                    lives.setSunstroke(sunstroke);
                    lives.setLoseWeight(lose);
                    lives.setBlood(blood);
                    lives.setDress(dress);
                    lives.setCarWash(car);
                    lives.setUltraviolet(ultraviolet);
                    liveHash.put(i, lives);//将lives对象加入到哈希链表中
                }
                Set<Integer> keys = liveHash.keySet();//获取哈希表的键
                for (Integer key : keys) {
                    Lives value = liveHash.get(key);
                    Connection conn = null;
                    //访问数据库
                    try {
                        PreparedStatement ps = null;
                        conn = DataUtils.getConnection();
                        String sql = "insert into lives(`location`,`sunstroke`,`lose_weight`,`blood`,`dress`,`car_wash`,`ultraviolet`) values(?,?,?,?,?,?,?)";
                        ps = conn.prepareStatement(sql);//预编译SQL，先写sql,然后不执行
                        ps.setString(1, value.getLocation());
                        ps.setString(2, value.getSunstroke());
                        ps.setString(3, value.getLoseWeight());
                        ps.setString(4, value.getBlood());
                        ps.setString(5, value.getDress());
                        ps.setString(6, value.getCarWash());
                        ps.setString(7, value.getUltraviolet());
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

    public static void main(String[] args) {
        parseLives();
    }
}
