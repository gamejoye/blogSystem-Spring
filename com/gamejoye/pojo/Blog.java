package com.gamejoye.pojo;

public class Blog {

    int id;
    String article_name;
    String username;
    String content;
    int ordered;

    public Blog(){

    }

    public Blog(String article_name,String username,String content,int ordered){
        this.article_name = article_name;
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

    public String getArticle_name() {
        return article_name;
    }

    public void setArticle_name(String article_name) {
        this.article_name = article_name;
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
                ", article_name='" + article_name + '\'' +
                ", username='" + username + '\'' +
                ", content='" + content + '\'' +
                ", ordered=" + ordered +
                '}';
    }
}
