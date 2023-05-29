package com.springboot.restapi.Udemy.service;

import com.springboot.restapi.Udemy.entity.Post;
import com.springboot.restapi.Udemy.payload.PostDto;
import com.springboot.restapi.Udemy.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService{

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(post.getDescription());
        post.setContent(postDto.getContent());
        return null;
    }
}
