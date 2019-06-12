package com.boc.music.factory;

import com.boc.music.parse.KuWoParse;
import com.boc.music.parse.ResourceParse;

import java.util.HashMap;
import java.util.Map;

/**
 * 解析对象工厂
 * @author boc
 * @since 2019-6-12 14:05:45
 */
public final class ParseFactory {

    private static final Map<Class, ResourceParse> RESOURCE_CACHE = new HashMap<>(4);

    public static ResourceParse createKuWoParse() {
        ResourceParse parse = RESOURCE_CACHE.get(KuWoParse.class);
        if (!(parse instanceof KuWoParse)) {
            parse = new KuWoParse();
            RESOURCE_CACHE.put(KuWoParse.class, parse);
        }
        return parse;
    }

}
