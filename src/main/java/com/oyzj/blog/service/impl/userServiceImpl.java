package com.oyzj.blog.service.impl;

import com.oyzj.blog.dao.userMapper;
import com.oyzj.blog.entity.user;
import com.oyzj.blog.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userServiceImpl implements userService {

    @Autowired
    private userMapper userMapper;

    @Override
    public user searchByid(int id) {
        return userMapper.selectById(id);
    }

    @Override
    public user search(user user) {
        return userMapper.search(user);
    }


}