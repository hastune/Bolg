package com.oyzj.blog.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.oyzj.blog.entity.user_info;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by oyzj on 2019/4/4.
 */
@Mapper
public interface user_infoMapper extends BaseMapper<user_info>{
    Integer insertOne(int id);
}
