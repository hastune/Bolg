package com.oyzj.blog.controller;

import com.oyzj.blog.entity.user_info;
import com.oyzj.blog.service.albumService;
import com.oyzj.blog.service.user_imgService;
import com.oyzj.blog.service.user_infoService;
import com.oyzj.blog.utils.requestUtils;
import com.oyzj.blog.utils.responce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

@RestController
@RequestMapping("info")
public class uerInfoController {

    @Autowired
    private user_infoService user_infoService;

    @Autowired
    private user_imgService user_imgService;

    @RequestMapping("search")
    public responce search(HttpServletRequest rq){
        responce r = new responce();
        int id = requestUtils.getUserId(rq);
        user_info u = user_infoService.search(id);
        if(u==null){
            //说明没有记录,创建一条
            r.setCode(204);
            r.setMsg("无信息");
            user_infoService.insertOne(id);
        }else{
            r.setCode(200);
            r.setMsg("成功");
            r.setData(u);
        }
        return r;
    }

    @RequestMapping("/update")
    public responce update(@RequestBody user_info user_info, HttpServletRequest rq){
        responce r = new responce();
        user_info.setId(requestUtils.getUserId(rq));
        if(user_infoService.update(user_info) == 1){
            r.setCode(200);
            r.setMsg("成功");
        }else{
            r.setCode(400);
            r.setMsg("更新失败，请联系管理员");
        }
        return r;
    }

    @RequestMapping("/upload")
    public responce imgUpload(MultipartFile file, HttpServletRequest rq){
        responce r= new responce();
        // 获得原始文件名+格式
        String name = file.getOriginalFilename().split("\\.")[1];
        String realname = requestUtils.getUserName(rq)+"_head"+"."+name;
        File f= new File("E:\\myFile\\file\\userimg\\head\\"+realname);
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (!file.isEmpty()) {
            try {
                FileOutputStream fos = new FileOutputStream(f);
                InputStream in = file.getInputStream();
                //InputStream in = request.getInputStream();
                byte[] bytes = new byte[1024];
                int len = 0;
                while ((len = in.read(bytes)) != -1) {
                    fos.write(bytes, 0, len);
                }
                fos.close();
                in.close();
                user_imgService.insertHeadImg(requestUtils.getUserId(rq),realname);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return r;
    }

}