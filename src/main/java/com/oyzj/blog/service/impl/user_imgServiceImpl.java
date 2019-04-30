package com.oyzj.blog.service.impl;

import com.oyzj.blog.dao.user_imgMapper;
import com.oyzj.blog.entity.user_img;
import com.oyzj.blog.service.user_imgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class user_imgServiceImpl implements user_imgService {

    @Autowired
    private user_imgMapper user_imgMapper;

    @Override
    public user_img search(int id) {
        user_img u = user_imgMapper.selectById(id);
        return u;
    }



    @Override
    public Integer insertHeadImg(int id,String path) {
        System.out.println(id+" "+path+"1111111111111111111111");
        user_img u = new user_img();
        u.setHeadImg(path);
        u.setId(id);
        if(user_imgMapper.selectById(id) == null){
            return user_imgMapper.insertOne(u);
        }else{
            return user_imgMapper.updateById(u);
        }

    }
}
