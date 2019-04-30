package com.oyzj.blog.service;

import com.oyzj.blog.entity.user_img;


public interface user_imgService {

    user_img search(int id);

    Integer insertHeadImg(int id,String path);

}
