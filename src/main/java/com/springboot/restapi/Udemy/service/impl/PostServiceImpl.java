package com.springboot.restapi.Udemy.service.impl;

import com.springboot.restapi.Udemy.entity.Post;
import com.springboot.restapi.Udemy.exception.ResourceNotFoundException;
import com.springboot.restapi.Udemy.payload.PostDto;
import com.springboot.restapi.Udemy.repository.PostRepository;
import com.springboot.restapi.Udemy.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        //convert Dto to entity using @builder
        Post post1 = Post.builder()
                .title(postDto.getTitle()).description(postDto.getDescription())
                .content(postDto.getContent()).build();
        Post newPost = postRepository.save(post1);

        //convert entity to Dto using @builder
        return PostDto.builder()
                .id(newPost.getId()).title(newPost.getTitle())
                .description(newPost.getDescription()).content(newPost.getContent()).build();
    }

    private Post mapToEntity(PostDto postDto){
        Post post = new Post();
        post.setId(postDto.getId());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        return post;
    }

    private PostDto mapToDto(Post post){
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        postDto.setContent(post.getContent());
        return postDto;
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(post ->mapToDto(post)).collect(Collectors.toList());
    }

    @Override
    public PostDto getPostsById(long id) {
        Post post = postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Posts", "id", id));
        return mapToDto(post);
    }

    @Override
    public PostDto updatePostById(PostDto postDto, long id) {
        // get post by id from the database
        Post post = postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Posts", "id", id));
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        Post updatedPost = postRepository.save(post);
        return mapToDto(updatedPost);
    }

    @Override
    public void deletePostById(long id) {
        // get post by id from the database
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        postRepository.delete(post);
    }
}
