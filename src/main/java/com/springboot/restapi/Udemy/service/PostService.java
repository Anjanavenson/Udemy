package com.springboot.restapi.Udemy.service;

import com.springboot.restapi.Udemy.payload.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);

    List<PostDto> getAllPosts();

    PostDto getPostsById(long id);

    PostDto updatePostById(PostDto postDto, long id);

    void deletePostById( long id);
}
