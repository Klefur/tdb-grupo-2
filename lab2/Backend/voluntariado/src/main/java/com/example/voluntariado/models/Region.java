package com.example.voluntariado.models;

/*
* This class represents a region.
* */
public class Region {
    private Integer gid;
    private String region_name;
    private String geometry;


    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getRegion_name() {
        return region_name;
    }

    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    }

    public String getGeometry() {
        return geometry;
    }

    public void setGeometry(String geometry) {
        this.geometry = geometry;
    }

    @Override
    public String toString(){
        return "Region{"+
                "gid=" + gid + ", region_name='" + region_name + '\'' +
                ", geometry='" + geometry + '\'' + '}';
    }
}
