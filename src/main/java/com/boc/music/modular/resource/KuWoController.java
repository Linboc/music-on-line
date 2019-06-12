package com.boc.music.modular.resource;

import com.boc.music.factory.ParseFactory;
import com.boc.music.parse.ResourceParse;
import com.boc.music.utils.MapBuild;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * 酷我音乐资源控制器
 * @author boc
 * @since 2019-6-12 14:02:23
 */
@RestController
@RequestMapping("kw")
public class KuWoController {

    private ResourceParse parse = ParseFactory.createKuWoParse();

    @GetMapping("/resource/{id}")
    public String resource(@PathVariable("id") String musicId, HttpServletResponse resp) {
        return parse.parseUrl(MapBuild.build("musicId", musicId).get());
    }

}
