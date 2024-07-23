package com.vti.blogapp.repository;

import com.vti.blogapp.dto.CommentDto;
import com.vti.blogapp.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CommentRepository extends
        JpaRepository<Comment, Comment.PrimaryKey> {
    //Method name
    Page<Comment> findByPostId(Long postId, Pageable pageable);

}
