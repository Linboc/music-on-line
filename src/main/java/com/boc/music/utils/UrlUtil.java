package com.boc.music.utils;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * url工具类
 * @author boc
 */
public class UrlUtil {

    public static String getData(String urlStr) {
        try (InputStream is = new URL(urlStr).openConnection().getInputStream()) {

            StringBuilder data = new StringBuilder();
            byte[] buf = new byte[1024];
            for (int count = -1; (count = is.read(buf)) >= 0; data.append(new String(buf, 0, count))) {
            }
            return data.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

}
