package com.springboot.restapi.Udemy.service;

import com.springboot.restapi.Udemy.payload.CommentDto;

public interface CommentService {
    CommentDto createComment(long postId, CommentDto commentDto);

}
