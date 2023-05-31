package com.springboot.restapi.Udemy.repository;

import com.springboot.restapi.Udemy.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
