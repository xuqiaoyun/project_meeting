package com.etc.entity;

public class Message {
    private Integer id;

    private String contentfact;

    private Integer meetingid;

    private Integer collectionid;

    private Integer sendid;

    private String mlocaltime;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContentfact() {
        return contentfact;
    }

    public void setContentfact(String contentfact) {
        this.contentfact = contentfact == null ? null : contentfact.trim();
    }

    public Integer getMeetingid() {
        return meetingid;
    }

    public void setMeetingid(Integer meetingid) {
        this.meetingid = meetingid;
    }

    public Integer getCollectionid() {
        return collectionid;
    }

    public void setCollectionid(Integer collectionid) {
        this.collectionid = collectionid;
    }

    public Integer getSendid() {
        return sendid;
    }

    public void setSendid(Integer sendid) {
        this.sendid = sendid;
    }

    public String getMlocaltime() {
        return mlocaltime;
    }

    public void setMlocaltime(String mlocaltime) {
        this.mlocaltime = mlocaltime == null ? null : mlocaltime.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}