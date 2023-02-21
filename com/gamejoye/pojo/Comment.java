package com.gamejoye.pojo;

public class Comment {
    int id;
    int blogId;
    String name;
    String content;
    String commentday;

    public int getId() {
        return id;
    }

    public Comment(String name, int blogId, String content, String commentday) {
        this.name = name;
        this.blogId = blogId;
        this.content = content;
        this.commentday = commentday;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", name=" + name +
                ", blogId=" + blogId +
                ", content='" + content + '\'' +
                ", commentday='" + commentday + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCommentday() {
        return commentday;
    }

    public void setCommentday(String commentday) {
        this.commentday = commentday;
    }
}
