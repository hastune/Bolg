package com.oyzj.blog.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.oyzj.blog.dao.AlbumMapper;
import com.oyzj.blog.entity.album;
import com.oyzj.blog.service.albumService;
import com.oyzj.blog.utils.requestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Service
public class AlbumServiceImpl implements albumService {

    @Autowired
    private AlbumMapper albumMapper;


    @Override
    public Integer getAlbumSum(HttpServletRequest rq) {
        return albumMapper.selectCount(new EntityWrapper<album>().eq("user_id", requestUtils.getUserId(rq)));
    }

    @Override
    public Integer insertAllColumn(album album) {
        return albumMapper.insertAllColumn(album);
    }

    @Override
    public Integer updateByPath(album album) {
        return albumMapper.updateByPath(album);
    }

    @Override
    public List<album> getAlbumImg(HttpServletRequest rq) {
        return albumMapper.selectList(new EntityWrapper<album>().eq("user_id",requestUtils.getUserId(rq)+""));
    }

}

