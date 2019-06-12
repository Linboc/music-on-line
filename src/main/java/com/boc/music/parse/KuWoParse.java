package com.boc.music.parse;

import com.boc.music.utils.UrlUtil;
import org.springframework.boot.json.BasicJsonParser;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.util.Assert;

import java.util.Map;
import java.util.Objects;

/**
 * 酷我url解析
 * @author boc
 */
public class KuWoParse implements ResourceParse {

    private static final String RESOURCE_URL = "https://antiserver.kuwo.cn/anti.s?rid=%s&format=aac|mp3&type=convert_url3";

    private static final String ID_PREFIX = "MUSIC_";

    @Override
    public String parseUrl(Map<String, String> param) {
        String musicId = param.get("musicId");
        Assert.hasLength(musicId, "请传入音乐id");
        Assert.isTrue(musicId.matches("\\d*"), "酷我音乐的id应该为纯数字，错误的id：" + musicId);

        String result = UrlUtil.getData(getTargetUrl(musicId));
        Assert.hasLength(result, "获取资源真实地址失败");
        Map<String, Object> data = new BasicJsonParser().parseMap(result);
        return Objects.requireNonNull(data.get("url"), "json解析失败，无法获取url，data：" + result).toString();
    }

    private String getTargetUrl(String musicId) {
        return String.format(RESOURCE_URL, ID_PREFIX + musicId);
    }

}
