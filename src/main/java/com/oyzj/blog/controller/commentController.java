package com.oyzj.blog.controller;

import com.oyzj.blog.entity.comment;
import com.oyzj.blog.service.commentService;
import com.oyzj.blog.utils.requestUtils;
import com.oyzj.blog.utils.responce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("com")
public class commentController {

    @Autowired
    private commentService commentService;


    @RequestMapping("get_sum")
    public responce get_sum(HttpServletRequest rq){
        responce r = new responce();
        r.setData(commentService.get_sum(rq));
        r.setCode(200);
        return r;
    }

    /**
     * 分页查询
     * @param rq Request对象 用于获取用户id
     * @param pageNum  当前页码
     * @param num 每页的数据量
     * @return
     */
    @RequestMapping("get_comment")
    public responce get_comment(HttpServletRequest
            rq,int pageNum,int num){
        responce r = new responce();
        r.setData(commentService.get_comment(rq,pageNum,num));
        r.setCode(200);
        return r;
    }


    @RequestMapping("add_com")
    public responce add_com(HttpServletRequest rq,String text){
        responce r= new responce();
        comment c = new comment();
        c.setComment(text);
        c.setRe_id(requestUtils.getUserId(rq));
        commentService.insert(c);
        return r;
    }
}
