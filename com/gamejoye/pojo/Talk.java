package com.gamejoye.pojo;

public class Talk {
    private int id;
    private UserInformation userInfo;
    private String content;
    private String releaseTime;
    private String mood;

    public Talk() {
    }

    public Talk(int id, UserInformation userInfo, String content, String releaseTime, String mood) {
        this.id = id;
        this.userInfo = userInfo;
        this.content = content;
        this.releaseTime = releaseTime;
        this.mood = mood;
    }

    @Override
    public String toString() {
        return "Talk{" +
                "id=" + id +
                ", userInfo=" + userInfo +
                ", content='" + content + '\'' +
                ", releaseTime='" + releaseTime + '\'' +
                ", mood='" + mood + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserInformation getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInformation userInfo) {
        this.userInfo = userInfo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }
}
