package com.gamejoye.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {
    public static String replaceAll(String regexBefore, String regexAfter, String content) {
        Pattern pattern = Pattern.compile(regexBefore);
        Matcher matcher = pattern.matcher(content);
        content = matcher.replaceAll(regexAfter);
        return content;
    }
    public static String replaceFirst(String regexBefore, String regexAfter, String content) {
        Pattern pattern = Pattern.compile(regexBefore);
        Matcher matcher = pattern.matcher(content);
        content = matcher.replaceFirst(regexAfter);
        return content;
    }
}
