package com.oyzj.blog.service;


import com.oyzj.blog.entity.comment;
import com.oyzj.blog.entity.commentResponce;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface commentService {


    Integer get_sum(HttpServletRequest rq);

    List<commentResponce> get_comment(HttpServletRequest rq, int pageNum, int num);

    Integer insert(comment comment);
}
