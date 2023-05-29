package com.springboot.restapi.Udemy.payload;

import lombok.Data;

@Data
public class PostDto {
    private long Id;
    private String Title;
    private String Description;
    private String Content;

}
