package com.gamejoye.constant;

public class URLConstants {
    private final static boolean IS_DEV = false;
    public final static String BLOG_URL = IS_DEV
            ? "http://localhost:3000"
            : "https://gamejoye.top";
    public final static String BLOG_ADMIN_URL = IS_DEV
            ? "http://localhost:3001"
            : "http://112.74.55.177:3001";
    public final static String localPath = IS_DEV
            ? "/users/gamejoye/images/blogs/"
            : "/usr/local/images/";
    public final static String URL_PATH = IS_DEV
            ? "http://localhost:8080/MyBlog/files/images/"
            : "https://gamejoye.top/images/";
}
