package com.boc.music;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 主启动类
 * @author boc
 */
@SpringBootApplication
@MapperScan("com.boc.music.**.mapper")
public class MusicOnLineApplication {

    public static void main(String[] args) {
        SpringApplication.run(MusicOnLineApplication.class, args);
    }

}
