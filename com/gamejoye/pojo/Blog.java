package com.gamejoye.pojo;

public class Blog {

    int id;
    String title;
    String name;
    String content;
    int ordered;

    public Blog(){

    }

    public Blog(String title,String name,String content,int ordered){
        this.title = title;
        this.name = name;
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
        return name;
    }

    public void setUsername(String username) {
        this.name = username;
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
                ", username='" + name + '\'' +
                ", content='" + content + '\'' +
                ", ordered=" + ordered +
                '}';
    }
}
