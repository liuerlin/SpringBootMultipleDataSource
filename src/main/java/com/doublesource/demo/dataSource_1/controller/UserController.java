package com.doublesource.demo.dataSource_1.controller;


import com.doublesource.demo.dataSource_1.entity.User;
import com.doublesource.demo.dataSource_1.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/getAllUser")
    public List index(){
        List<User> userLst = userMapper.getAllUser();
        return userLst;
    }
}