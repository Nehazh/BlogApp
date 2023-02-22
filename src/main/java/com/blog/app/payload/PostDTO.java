package com.blog.app.payload;


import lombok.Data;

//To trabsfer data between client and server.
//Thye can help to hide the implement in jpa

@Data
public class PostDTO {
    private long id;
    private String title;
    private String description;
    private String content;

}
