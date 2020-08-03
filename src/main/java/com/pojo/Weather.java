package com.pojo;
/**
 * 实体类
 */

import lombok.Data;
import java.util.Date;

@Data
public class Weather {

    private String id;
    private String location;
    private String date;
    private String status;
    private String maxTem;
    private String minTem;
    private String tem;
    private String windLevel;

    public String getTem() {
        return tem;
    }

    public void setTem(String tem) {
        this.tem = tem;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity() {
        return location;
    }

    public void setCity(String city) {
        this.location = city;
    }

    public String getDate() {
        return date;
    }

//    public void setDate(String date) {
//        this.date = date;
//    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMaxTem() {
        return maxTem;
    }

    public void setMaxTem(String maxTem) {
        this.maxTem = maxTem;
    }

    public String getMinTem() {
        return minTem;
    }

    public void setMinTem(String minTem) {
        this.minTem = minTem;
    }

    public String getWindLevel() {
        return windLevel;
    }

    public void setWindLevel(String windLevel) {
        this.windLevel = windLevel;
    }

    public Weather(String id, String location, String date, String status, String maxTem, String minTem, String windLevel, Date update_time) {
        super();
        this.id = id;
        this.location = location;
        this.date = date;
        this.status = status;
        this.maxTem = maxTem;
        this.minTem = minTem;
        this.windLevel = windLevel;
    }
    public Weather() {
        super();
    }

    @Override
    public String toString() {
        return "Weather{" +
                "id='" + id + '\'' +
                ", location='" + location + '\'' +
                ", date='" + date + '\'' +
                ", status='" + status + '\'' +
                ", maxTem='" + maxTem + '\'' +
                ", minTem='" + minTem + '\'' +
                ", tem='" + tem + '\'' +
                ", windLevel='" + windLevel + '\'' +
                '}';
    }
}
