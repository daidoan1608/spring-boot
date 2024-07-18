package com.vti.blogapp.service;

import com.vti.blogapp.dto.CommentDto;
import com.vti.blogapp.form.CommentCreateForm;
import com.vti.blogapp.form.CommentUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface CommentService {
    Page<CommentDto> findAll(Pageable pageable);

    Page<CommentDto> findByPostId(Long postId, Pageable pageable);

    CommentDto findById(UUID id);

    CommentDto create(Long postId, CommentCreateForm form);

    CommentDto update(UUID id, CommentUpdateForm form);

    void delete(UUID id);

    void deleteByEmail(String email);
}
