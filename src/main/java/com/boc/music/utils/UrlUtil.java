package com.boc.music.utils;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

/**
 * url工具类
 * @author boc
 */
public class UrlUtil {

    public static final RestTemplate CLIENT = new RestTemplate();

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

    public static String getKuwoPage(String key, String pn, String rn) {
        String reqId = UUID.randomUUID().toString();
        String url = String.format("http://kuwo.cn/api/www/search/searchMusicBykeyWord?key=%s&pn=%s&rn=%s&reqId=%s", key, pn, rn, reqId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Referer", "kuwo.cn");
        headers.add("Cookie", "kw_token=a");
        headers.add("csrf", "a");
        HttpEntity<String> requestEntity = new HttpEntity((Object)null, headers);
        return CLIENT.exchange(url, HttpMethod.GET, requestEntity, String.class, new Object[0]).getBody();
    }

    public static String getAcFunM3u8Url(String url) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.163 Safari/537.36");
        HttpEntity<String> requestEntity = new HttpEntity((Object)null, headers);
        return CLIENT.exchange(url, HttpMethod.GET, requestEntity, String.class, new Object[0]).getBody();
    }

}
