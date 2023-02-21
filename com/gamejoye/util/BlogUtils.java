package com.gamejoye.util;

import com.gamejoye.constant.FormatConstants;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BlogUtils {
    public static String formConversion(String content) {
        // 博客格式转换
        content = RegexUtils.replaceAll(FormatConstants.TAB_LEADING_END, FormatConstants.TAB, content);
        content = RegexUtils.replaceAll(FormatConstants.BLANK_LEADING_END, FormatConstants.BLANK, content);
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile("```\n([^`]|\n)*\n```");
        Matcher matcher = pattern.matcher(content);
        int last = 0;
        while(matcher.find()) {
            sb.append(content.substring(last, matcher.start()));
            last = matcher.end();
            String s = matcher.group(0).replaceAll("&lt;", "<");
            s = s.replaceAll("&gt;", ">");
            s = s.replaceAll("&amp;", "&");
            sb.append(s);
        }
        sb.append(content.substring(last));
        return sb.toString();
    }
}
