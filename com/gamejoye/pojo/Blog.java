package com.gamejoye.pojo;

public class Blog {

    int id;
    String title;
    String username;
    String content;
    int ordered;

    public Blog(){

    }

    public Blog(String title,String username,String content,int ordered){
        this.title = title;
        this.username = username;
        this.content = content;
        this.ordered = ordered;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String gettitle() {
        return title;
    }

    public void settitle(String title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getOrdered() {
        return ordered;
    }

    public void setOrdered(int ordered) {
        this.ordered = ordered;
    }

    @Override
    public String toString() {
        return "BlogInfo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", username='" + username + '\'' +
                ", content='" + content + '\'' +
                ", ordered=" + ordered +
                '}';
    }
}
