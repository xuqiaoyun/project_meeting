package com.etc.entity;

import java.util.Date;

public class Application {
    private Integer id;

    private Integer micro;

    private Integer projector;

    private String carword;

    private String banner;

    private String tablesign;

    private Integer tea;

    private Date signtime;

    private String signlocation;

    private Integer dinnertype;

    private Integer dinnenum;

    private String dinnerremarks;

    private Integer roomtype;

    private Integer roomnum;

    private String roomremarks;

    private String remarks;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMicro() {
        return micro;
    }

    public void setMicro(Integer micro) {
        this.micro = micro;
    }

    public Integer getProjector() {
        return projector;
    }

    public void setProjector(Integer projector) {
        this.projector = projector;
    }

    public String getCarword() {
        return carword;
    }

    public void setCarword(String carword) {
        this.carword = carword == null ? null : carword.trim();
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner == null ? null : banner.trim();
    }

    public String getTablesign() {
        return tablesign;
    }

    public void setTablesign(String tablesign) {
        this.tablesign = tablesign == null ? null : tablesign.trim();
    }

    public Integer getTea() {
        return tea;
    }

    public void setTea(Integer tea) {
        this.tea = tea;
    }

    public Date getSigntime() {
        return signtime;
    }

    public void setSigntime(Date signtime) {
        this.signtime = signtime;
    }

    public String getSignlocation() {
        return signlocation;
    }

    public void setSignlocation(String signlocation) {
        this.signlocation = signlocation == null ? null : signlocation.trim();
    }

    public Integer getDinnertype() {
        return dinnertype;
    }

    public void setDinnertype(Integer dinnertype) {
        this.dinnertype = dinnertype;
    }

    public Integer getDinnenum() {
        return dinnenum;
    }

    public void setDinnenum(Integer dinnenum) {
        this.dinnenum = dinnenum;
    }

    public String getDinnerremarks() {
        return dinnerremarks;
    }

    public void setDinnerremarks(String dinnerremarks) {
        this.dinnerremarks = dinnerremarks == null ? null : dinnerremarks.trim();
    }

    public Integer getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(Integer roomtype) {
        this.roomtype = roomtype;
    }

    public Integer getRoomnum() {
        return roomnum;
    }

    public void setRoomnum(Integer roomnum) {
        this.roomnum = roomnum;
    }

    public String getRoomremarks() {
        return roomremarks;
    }

    public void setRoomremarks(String roomremarks) {
        this.roomremarks = roomremarks == null ? null : roomremarks.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}