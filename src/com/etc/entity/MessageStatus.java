package com.etc.entity;

public class MessageStatus {
    private Integer id;

    private String readid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReadid() {
        return readid;
    }

    public void setReadid(String readid) {
        this.readid = readid == null ? null : readid.trim();
    }
}