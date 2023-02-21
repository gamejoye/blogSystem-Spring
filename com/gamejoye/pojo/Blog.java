package com.gamejoye.pojo;

import com.alibaba.fastjson.JSONArray;

import java.util.List;

public class Blog {

    int id;
    int ordered;
    String title;
    String name;
    String content;
    JSONArray tags;

    public Blog(){

    }

    public Blog(String title,String name,String content,int ordered, JSONArray tags){
        this.title = title;
        this.name = name;
        this.content = content;
        this.ordered = ordered;
        this.tags = tags;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrdered() {
        return ordered;
    }

    public void setOrdered(int ordered) {
        this.ordered = ordered;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public JSONArray getTags() {
        return tags;
    }

    public void setTags(JSONArray tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", ordered=" + ordered +
                ", title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", tags='" + tags + '\'' +
                '}';
    }
}
