package com.boc.music.modular.resource;

import com.boc.music.factory.ParseFactory;
import com.boc.music.parse.ResourceParse;
import com.boc.music.utils.MapBuild;
import com.boc.music.utils.UrlUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 酷我音乐资源控制器
 * @author boc
 * @since 2019-6-12 14:02:23
 */
@RestController
@RequestMapping("kw")
public class KuWoController {

    private final ResourceParse PARSE = ParseFactory.createKuWoParse();

    @GetMapping("/resource/{id}")
    public String resource(@PathVariable("id") String musicId) {
        return PARSE.parseUrl(MapBuild.build("musicId", musicId).get());
    }

    @GetMapping({"page"})
    public String page(String key, String pn, String rn) {
        return UrlUtil.getKuwoPage(key, pn, rn);
    }

}
