package com.oyzj.blog.service;


import com.oyzj.blog.entity.user;

public interface userService {

    user searchByid(int id);

    user search(user user);
}