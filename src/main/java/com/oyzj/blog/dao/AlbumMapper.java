package com.oyzj.blog.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.oyzj.blog.entity.album;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface AlbumMapper extends BaseMapper<album> {

    Integer updateByPath(album album);
}
