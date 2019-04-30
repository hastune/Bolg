package com.oyzj.blog.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.oyzj.blog.entity.user_img;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface user_imgMapper extends BaseMapper<user_img> {

    Integer insertOne(user_img user_img);

    
}
