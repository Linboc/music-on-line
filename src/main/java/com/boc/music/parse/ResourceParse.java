package com.boc.music.parse;

import java.util.Map;

/**
 * 资源解析接口
 * @author boc
 */
public interface ResourceParse {

    /**
     * 解析资源的路径
     * @param param 获取url的参数
     * @return 返回资源的Url
     */
    String parseUrl(Map<String, String> param);

}
