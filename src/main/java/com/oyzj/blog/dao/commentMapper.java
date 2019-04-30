package com.oyzj.blog.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.oyzj.blog.entity.comment;
import com.oyzj.blog.entity.commentResponce;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface commentMapper extends BaseMapper<comment> {

    List<commentResponce> get_comment(@Param("id") String id, @Param("start") Integer start, @Param("limit") Integer limit);
}
