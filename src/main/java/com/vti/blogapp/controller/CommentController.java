package com.vti.blogapp.controller;

import com.vti.blogapp.dto.CommentDto;
import com.vti.blogapp.form.CommentCreateForm;
import com.vti.blogapp.form.CommentFilterForm;
import com.vti.blogapp.form.CommentUpdateForm;
import com.vti.blogapp.service.CommentService;
import com.vti.blogapp.validation.CommentIdExists;
import com.vti.blogapp.validation.PostIdExists;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@AllArgsConstructor
public class CommentController {
    private CommentService commentService;

    @GetMapping("/api/v1/comments")
    public Page<CommentDto> findAll(
            CommentFilterForm form,
            Pageable pageable
    ) {
        return commentService.findAll(form, pageable);
    }

    @GetMapping("/api/v1/comments/{id}")
    public CommentDto findById(@CommentIdExists @PathVariable("id") Long id) {
        return commentService.findById(id);
    }

    @GetMapping("/api/v1/posts/{postId}/comments")
    public Page<CommentDto> findByPostId(
            @PostIdExists @PathVariable("postId") Long postId,
            Pageable pageable
    ) {
        return commentService.findByPostId(postId, pageable);
    }

    @PostMapping("/api/v1/posts/{postId}/comments")
    public CommentDto create(
            @PostIdExists @PathVariable("postId") Long postId,
            @Valid @RequestBody CommentCreateForm form
    ) {
        return commentService.create(postId, form);
    }

    @PutMapping("/api/v1/comments/{id}")
    public CommentDto update(
            @CommentIdExists @PathVariable("id") Long id,
            @Valid @RequestBody CommentUpdateForm form
    ) {
        return commentService.update(id, form);
    }

    @DeleteMapping("/api/v1/comments/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        commentService.delete(id);
    }

    @DeleteMapping("/api/v1/comments/email/{email}")
    public void deleteByEmail(@PathVariable("email") String email) {
        commentService.deleteByEmail(email);
    }
}
