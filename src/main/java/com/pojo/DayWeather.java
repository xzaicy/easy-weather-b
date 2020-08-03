package com.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class DayWeather {
    private String id;
    private String location;
    private String hour;
    private String tem;
    private String wind;
    private String windLevel;
    private Date update_time;

    public DayWeather(String id, String location, String hour, String tem, String wind, String windLevel, Date update_time) {
        this.id = id;
        this.location = location;
        this.hour = hour;
        this.tem = tem;
        this.wind = wind;
        this.windLevel = windLevel;
        this.update_time = update_time;
    }

    public DayWeather() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getTem() {
        return tem;
    }

    public void setTem(String tem) {
        this.tem = tem;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getWindLevel() {
        return windLevel;
    }

    public void setWindLevel(String windLevel) {
        this.windLevel = windLevel;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        return "DayWeather{" +
                "id='" + id + '\'' +
                ", location='" + location + '\'' +
                ", hour='" + hour + '\'' +
                ", tem='" + tem + '\'' +
                ", wind='" + wind + '\'' +
                ", windLevel='" + windLevel + '\'' +
                ", update_time=" + update_time +
                '}';
    }
}
