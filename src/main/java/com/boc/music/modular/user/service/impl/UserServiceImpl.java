package com.boc.music.modular.user.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.boc.music.modular.user.entity.User;
import com.boc.music.modular.user.mapper.UserMapper;
import com.boc.music.modular.user.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author boc
 * @since 2019-06-11
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public User getByName(String name) {
        return getOne(Wrappers.<User>query().eq("username", name));
    }
}
