package com.oyzj.blog.service;

import com.oyzj.blog.entity.user_info;

/**
 * Created by oyzj on 2019/4/4.
 */
public interface user_infoService {

    Integer update(user_info user_info);

    user_info search(int id);

    Integer insertOne(int id);
}
