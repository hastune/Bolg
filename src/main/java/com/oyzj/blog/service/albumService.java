package com.oyzj.blog.service;


import com.oyzj.blog.entity.album;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public interface albumService {

    Integer getAlbumSum(HttpServletRequest rq);

    Integer insertAllColumn(album album);

    Integer updateByPath(album album);

    List<album> getAlbumImg(HttpServletRequest rq);
}
