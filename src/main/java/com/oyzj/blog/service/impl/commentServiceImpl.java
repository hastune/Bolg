package com.oyzj.blog.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.oyzj.blog.dao.commentMapper;
import com.oyzj.blog.entity.comment;
import com.oyzj.blog.entity.commentResponce;
import com.oyzj.blog.service.commentService;
import com.oyzj.blog.utils.requestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class commentServiceImpl implements commentService {

    @Autowired
    private commentMapper commentMapper;

    @Override
    public Integer get_sum(HttpServletRequest rq) {
        return commentMapper.selectCount(new EntityWrapper<comment>().eq("re_id", requestUtils.getUserId(rq)));
    }

    @Override
    public List<commentResponce> get_comment(HttpServletRequest rq, int pageNum, int num) {
        int start = (pageNum-1)*num;
        return commentMapper.get_comment(requestUtils.getUserId(rq)+"",start,num);
    }

    @Override
    public Integer insert(comment comment) {
        return commentMapper.insertAllColumn(comment);
    }
}
