package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataUtils {
    public static final String Driver = "com.mysql.jdbc.Driver";
    public static final String url = "jdbc:mysql://localhost:3306/weather?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=true";
    public static final String user = "root";
    public static final String password = "root";

    static {
        try {
            Class.forName(Driver);
        } catch (ClassNotFoundException e) {
            System.out.println("找不到驱动程序类，加载驱动失败！");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);//Connection代表数据库
        return conn;
    }
}