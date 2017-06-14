package com.etc.entity;

import java.util.Date;

public class Meeting {
    private Integer id;

    private String name;

    private String introduce;

    private String content;

    private Integer commentid;

    private Integer type;

    private Integer meetingroom;

    private Date starttime;

    private Date endtime;

    private Integer holder;

    private String recorder;

    private String joiner;

    private Integer number;

    private String check;

    private String checkmess;

    private String lerader;

    private String medias;

    private String opener;

    private Integer applicationid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getCommentid() {
        return commentid;
    }

    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getMeetingroom() {
        return meetingroom;
    }

    public void setMeetingroom(Integer meetingroom) {
        this.meetingroom = meetingroom;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Integer getHolder() {
        return holder;
    }

    public void setHolder(Integer holder) {
        this.holder = holder;
    }

    public String getRecorder() {
        return recorder;
    }

    public void setRecorder(String recorder) {
        this.recorder = recorder == null ? null : recorder.trim();
    }

    public String getJoiner() {
        return joiner;
    }

    public void setJoiner(String joiner) {
        this.joiner = joiner == null ? null : joiner.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check == null ? null : check.trim();
    }

    public String getCheckmess() {
        return checkmess;
    }

    public void setCheckmess(String checkmess) {
        this.checkmess = checkmess == null ? null : checkmess.trim();
    }

    public String getLerader() {
        return lerader;
    }

    public void setLerader(String lerader) {
        this.lerader = lerader == null ? null : lerader.trim();
    }

    public String getMedias() {
        return medias;
    }

    public void setMedias(String medias) {
        this.medias = medias == null ? null : medias.trim();
    }

    public String getOpener() {
        return opener;
    }

    public void setOpener(String opener) {
        this.opener = opener == null ? null : opener.trim();
    }

    public Integer getApplicationid() {
        return applicationid;
    }

    public void setApplicationid(Integer applicationid) {
        this.applicationid = applicationid;
    }
}