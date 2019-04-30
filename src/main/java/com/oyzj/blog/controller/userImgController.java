package com.oyzj.blog.controller;


import com.oyzj.blog.entity.album;
import com.oyzj.blog.service.albumService;
import com.oyzj.blog.service.user_imgService;
import com.oyzj.blog.utils.requestUtils;
import com.oyzj.blog.utils.responce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class userImgController {

    @Autowired
    private user_imgService user_imgService;

    @Autowired
    private albumService albumService;

    @RequestMapping("/getUserHead")
    public responce search(HttpServletRequest rq){
        responce r = new responce();
        r. setData(user_imgService.search(requestUtils.getUserId(rq)));
        r.setMsg("成功");
        r.setCode(200);
        return r;
    }

    @RequestMapping("/getAblumSum")
    public responce getAblumSum(HttpServletRequest rq){
        responce r = new responce();
        r.setData(albumService.getAlbumSum(rq));
        return r;
    }

    @PostMapping("insertImgInfo")
    public responce insertImgInfo(HttpServletRequest rq){
        responce r = new responce();

        return r;
    }

    @RequestMapping("/upload")
    public responce imgUpload(MultipartFile file, HttpServletRequest rq, String type, String place, String desc){
        System.out.println(type+" "+place+" "+desc);
        responce r= new responce();
        // 获得原始文件名+格式
        // 获得文件格式
        String name = file.getOriginalFilename().split("\\.")[1];
        String realname = requestUtils.getUserName(rq)+"_"+type+(albumService.getAlbumSum(rq)+1)+"."+name;
        File f= new File("E:\\myFile\\file\\userimg\\"+type+"\\"+realname);
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
                byte[] bytes = new byte[1024];
                int len = 0;
                while ((len = in.read(bytes)) != -1) {
                    fos.write(bytes, 0, len);
                }
                fos.close();
                in.close();
                album a = new album();
                a.setImgPath(realname);
                a.setUserId(requestUtils.getUserId(rq));
                SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
                a.setTime(sf.format(new Date()));
                albumService.insertAllColumn(a);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        r.setData(realname);
        r.setCode(200);
        r.setMsg("成功");
        return r;
    }

    /**
     * 根据path更新字段
     * @param
     * @return
     */
    @RequestMapping("jsAlbum")
    public responce jsAlbum(String path,String desc,String place){
        responce r = new responce();
        album album = new album();
        album.setImgPath(path);
        album.setImgDesc(desc);
        album.setImgPleace(place);
        r.setData(albumService.updateByPath(album));
        r.setMsg("成功");
        return r;
    }

    @RequestMapping("getAlbumImg")
    public responce getAlbumImg(HttpServletRequest rq){
        responce r = new responce();
        r.setData(albumService.getAlbumImg(rq));
        return r;
    }
}
