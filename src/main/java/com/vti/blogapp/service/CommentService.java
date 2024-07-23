package com.vti.blogapp.service;

import com.vti.blogapp.dto.CommentDto;
import com.vti.blogapp.entity.Comment;
import com.vti.blogapp.form.CommentCreateForm;
import com.vti.blogapp.form.CommentUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentService {
    Page<CommentDto> findAll(Pageable pageable);

    Page<CommentDto> findByPostId(Long postId, Pageable pageable);

    CommentDto findById(Comment.PrimaryKey pk);

    CommentDto create(Long postId, CommentCreateForm form);

    CommentDto update(Comment.PrimaryKey pk, CommentUpdateForm form);

    void delete(Comment.PrimaryKey pk);

    void deleteByEmail(String email);
}
