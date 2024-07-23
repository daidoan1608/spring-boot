package com.vti.blogapp.controller;

import com.vti.blogapp.dto.CommentDto;
import com.vti.blogapp.entity.Comment;
import com.vti.blogapp.form.CommentCreateForm;
import com.vti.blogapp.form.CommentUpdateForm;
import com.vti.blogapp.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class CommentController {
    private CommentService commentService;

    @GetMapping("/api/v1/comments")
    public Page<CommentDto> findAll(Pageable pageable) {
        return commentService.findAll(pageable);
    }

    @GetMapping("/api/v1/comments/{id}")
    public CommentDto findById(@PathVariable("id") Comment.PrimaryKey id) {
        return commentService.findById(id);
    }

    @GetMapping("/api/v1/posts/{postId}/comments")
    public Page<CommentDto> findByPostId(
            @PathVariable("postId") Long postId,
            Pageable pageable
    ) {
        return commentService.findByPostId(postId, pageable);
    }

    @PostMapping("/api/v1/posts/{postId}/comments")
    public CommentDto create(
            @PathVariable("postId") Long postId,
            @RequestBody CommentCreateForm form
    ) {
        return commentService.create(postId, form);
    }

    @PutMapping("/api/v1/comments/{id}")
    public CommentDto update(
            @PathVariable("id") Comment.PrimaryKey id,
            @RequestBody CommentUpdateForm form
    ) {
        return commentService.update(id, form);
    }

    @DeleteMapping("/api/v1/comments/{id}")
    public void deleteById(@PathVariable("id") Comment.PrimaryKey id) {
        commentService.delete(id);
    }

    @DeleteMapping("/api/v1/comments/email/{email}")
    public void deleteByEmail(@PathVariable("email") String email) {
        commentService.deleteByEmail(email);
    }
}
