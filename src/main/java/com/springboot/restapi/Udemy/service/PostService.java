package com.springboot.restapi.Udemy.service;

import com.springboot.restapi.Udemy.payload.PostDto;

public interface PostService {
    PostDto createPost(PostDto postDto);
}
