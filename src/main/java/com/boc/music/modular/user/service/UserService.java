package com.boc.music.modular.user.service;

import com.boc.music.modular.user.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author boc
 * @since 2019-06-11
 */
public interface UserService extends IService<User> {

    /**
     * 根据用户名获取用户
     * @param name 用户名
     * @return 用户
     */
    User getByName(String name);

}
