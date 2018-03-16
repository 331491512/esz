package com.westangel.common.util.location;

public class Location {

    private String data;
    // 经度
    private double latitude;

    // 纬度
    private double longtitude;

    public double getX() {
        return latitude;
    }

    public void setX(double x) {
        this.latitude = x;
    }

    public double getY() {
        return longtitude;
    }

    public void setY(double y) {
        this.longtitude = y;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        Location other = (Location) obj;
        if (this.getX() == other.getX() && this.getY() == other.getY()) {
            return true;
        }
        return false;
    }
    
    // 计算空间距离
    public static double getDistance(Location loc1, Location loc2) {
         double  distance=Math.pow(loc1.getX()-loc2.getX(),2)+Math.pow(loc1.getY()-loc2.getY(),2);
         return Math.sqrt(distance)*111199.233;         
    }
}
