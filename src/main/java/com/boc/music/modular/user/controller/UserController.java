package com.boc.music.modular.user.controller;


import com.boc.music.modular.user.entity.User;
import com.boc.music.modular.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author boc
 * @since 2019-06-11
 */
@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping("/byName")
    public User getUserByName(@RequestParam("name") String name) {
        return userService.getByName(name);
    }

}