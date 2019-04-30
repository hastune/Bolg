package com.oyzj.blog.entity;

import lombok.Data;

@Data
public class comment {

    private int send_id;
    private int re_id;
    private String comment;
    private String time;
}
