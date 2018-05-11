package com.example.administrator.app.util;

import com.example.administrator.mvpdemo.constant.Constants;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * Created by ws on 18-5-11.
 */

public class MvpDemoUtil {
    public static String appendUrl(String douBanUrl, Map<String, String> parameters) {
        StringBuilder sb = new StringBuilder();
        sb.append(douBanUrl);
        boolean first = true;

        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (first) {
                first = false;
                sb.append("?");
            } else {
                sb.append("&");
            }
            try {
                sb.append(URLEncoder.encode(key, Constants.UTF_8) + "="
                    + URLEncoder.encode(value, Constants.UTF_8));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
