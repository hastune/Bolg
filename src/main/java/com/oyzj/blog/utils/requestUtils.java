package com.oyzj.blog.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by oyzj on 2019/4/4.
 */
public class requestUtils {

    public static String getCookieValue(HttpServletRequest rq,String name){
        Cookie[] c = rq.getCookies();
        String value ="";
        for(Cookie e : c){
            if( e.getName().equals(name)){
                value = e.getValue();
                break;
            }
        }
        return value;
    }

    public static int getUserId(HttpServletRequest rq){
        Cookie[] c = rq.getCookies();
        int id =0;
        for(Cookie e : c){
            if( e.getName().equals("user")){
                id = new Integer(e.getValue().split("-")[0]);
                break;
            }
        }
        return id;
    }

    public static String getUserName(HttpServletRequest rq){
        Cookie[] c = rq.getCookies();
        String name ="";
        for(Cookie e : c){
            if( e.getName().equals("user")){
                name = e.getValue().split("-")[1];
                break;
            }
        }
        return name;
    }
}