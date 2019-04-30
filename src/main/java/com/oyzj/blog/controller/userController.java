package com.oyzj.blog.controller;


import com.oyzj.blog.entity.user;
import com.oyzj.blog.service.userService;
import com.oyzj.blog.utils.responce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController {

    @Autowired
    private userService userService;

    @RequestMapping("/test")
    public user test(){
        return userService.searchByid(1);
    }

    @RequestMapping("/login")
    public responce login(String name,String password){
//        System.out.print(name+"  "+password);
        responce r = new responce();
        user u = new user();
        u.setName(name);
        u.setPassword(password);
        user user =userService.search(u);
        if(user != null && user.getName().equals(u.getName()) && user.getPassword().equals(user.getPassword())){
            r.setData(userService.search(u));
            r.setCode(200);
            r.setMsg("homepage");
        }else{
            r.setCode(500);
            r.setMsg("用户名或密码错误");
        }
    return r;
    }


//    public responce compare

    @RequestMapping("selectById")
    public responce selectById(int userId){
        responce r = new responce();
        r.setData(userService.searchByid(userId));
        r.setCode(200);
        return r;
    }
}