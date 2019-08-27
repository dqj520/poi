package com.baizhi.com.baizhi.entity;

import java.util.Date;

public class Students {
    private String id;
    private String name;
    private Date bri;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBri() {
        return bri;
    }

    public void setBri(Date bri) {
        this.bri = bri;
    }

    public Students() {
    }

    public Students(String id, String name, Date bri) {
        this.id = id;
        this.name = name;
        this.bri = bri;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", bri=" + bri +
                '}';
    }
}
