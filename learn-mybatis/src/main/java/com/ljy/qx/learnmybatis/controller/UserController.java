package com.ljy.qx.learnmybatis.controller;

import com.ljy.qx.learnmybatis.entity.User;
import com.ljy.qx.learnmybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.rowset.spi.SyncResolver;

/**
 * @author : 夕
 * @date : 2019/10/21
 */

@RestController
public class UserController {

    @Autowired
    User user;

    @Autowired
    UserService userService;

    @GetMapping("/add")
    public int  addUser(){
        user.setId(004);
        user.setName("test04");
        user.setAge(23);
        user.setSex("men");
        return userService.addUser(user);
    }

    @GetMapping("/query")
    public String queryUserById(){
        return userService.queryUser(1).toString();
    }

}
