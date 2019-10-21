package com.ljy.qx.learnmybatis.service;

import com.ljy.qx.learnmybatis.entity.User;
import com.ljy.qx.learnmybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : 夕
 * @date : 2019/10/21
 */

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public int addUser(User user){
        return userMapper.add(user);
    }

    public User queryUser(int id){
        return userMapper.queryById(id);
    }
}
