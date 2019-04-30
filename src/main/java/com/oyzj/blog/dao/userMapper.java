package com.oyzj.blog.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.oyzj.blog.entity.user;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface userMapper extends BaseMapper<user>{

    user search(user user);

}