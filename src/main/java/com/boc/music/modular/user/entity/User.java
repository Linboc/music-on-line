package com.boc.music.modular.user.entity;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 用户表
 * @author boc
 * @since 2019-06-11
 */
@Data
@Accessors(chain = true)
public class User {

    private static final long serialVersionUID = 1L;

    /** 用户名 */
    private String username;

    /** 密码 */
    private String password;

    /** 创建时间 */
    private LocalDateTime createTime;

    /** 修改时间 */
    private LocalDateTime updateTime;

    /** 版本号 */
    private Integer versionOn;

    /** 是否删除，0：正常（默认），1：已删除 */
    private String delFlag;

}
