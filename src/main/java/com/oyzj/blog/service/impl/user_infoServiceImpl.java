package com.oyzj.blog.service.impl;

import com.oyzj.blog.dao.user_infoMapper;
import com.oyzj.blog.entity.user_info;
import com.oyzj.blog.service.user_infoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yt on 2019/4/4.
 */
@Service
public class user_infoServiceImpl implements user_infoService {

    @Autowired
    private user_infoMapper user_infoMapper;

    @Override
    public Integer update(user_info user_info) {
        return user_infoMapper.updateById(user_info);
    }

    @Override
    public user_info search(int id) {
        return user_infoMapper.selectById(id);
    }

    @Override
    public Integer insertOne(int id) {
        return user_infoMapper.insertOne(id);
    }
}