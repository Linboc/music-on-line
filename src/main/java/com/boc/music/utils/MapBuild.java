package com.boc.music.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Map工具类
 * @author boc
 */
public class MapBuild {

    private Map<String, String> param;

    public MapBuild(Map<String, String> param) {
        this.param = param;
    }

    public static MapBuild build(String key, String value) {
        Map<String, String> map = new HashMap<>(2);
        map.put(key, value);
        return  new MapBuild(map);
    }

    public Map<String, String> get() {
        return param;
    }

    public MapBuild put(String key, String value) {
        param.put(key, value);
        return this;
    }

}
