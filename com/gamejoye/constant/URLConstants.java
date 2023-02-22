package com.gamejoye.constant;

public class URLConstants {
    private final static boolean IS_DEV = true;
    public final static String BLOG_URL = IS_DEV
            ? "http://localhost:3000"
            : "https://gamejoye.top";
    public final static String BLOG_ADMIN_URL = IS_DEV
            ? "http://localhost:3001"
            : "http://112.74.55.177:3001";
    public final static String LOCAL_Path = IS_DEV
            ? "/users/gamejoye/webapp/blog/images/"
            : "/usr/local/images/";
    public final static String URL_PATH = IS_DEV
            ? "http://localhost:82/images/"
            : "https://gamejoye.top/images/";
}
