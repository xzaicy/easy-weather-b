package com.pojo;

public class Lives {
    private int id;
    private String location;
    private String sunstroke;
    private String loseWeight;
    private String blood;
    private String dress;
    private String carWash;
    private String ultraviolet;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSunstroke() {
        return sunstroke;
    }

    public void setSunstroke(String sunstroke) {
        this.sunstroke = sunstroke;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getDress() {
        return dress;
    }

    public void setDress(String dress) {
        this.dress = dress;
    }


    public String getUltraviolet() {
        return ultraviolet;
    }

    public void setUltraviolet(String ultraviolet) {
        this.ultraviolet = ultraviolet;
    }

    public Lives() {
    }

    public String getLoseWeight() {
        return loseWeight;
    }

    public void setLoseWeight(String loseWeight) {
        this.loseWeight = loseWeight;
    }

    public String getCarWash() {
        return carWash;
    }

    public void setCarWash(String carWash) {
        this.carWash = carWash;
    }

    public Lives(int id, String location, String sunstroke, String loseWeight, String blood, String dress, String carWash, String ultraviolet) {
        this.id = id;
        this.location = location;
        this.sunstroke = sunstroke;
        this.loseWeight = loseWeight;
        this.blood = blood;
        this.dress = dress;
        this.carWash = carWash;
        this.ultraviolet = ultraviolet;
    }

    @Override
    public String toString() {
        return "Lives{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", sunstroke='" + sunstroke + '\'' +
                ", loseWeight='" + loseWeight + '\'' +
                ", blood='" + blood + '\'' +
                ", dress='" + dress + '\'' +
                ", carWash='" + carWash + '\'' +
                ", ultraviolet='" + ultraviolet + '\'' +
                '}';
    }
}
