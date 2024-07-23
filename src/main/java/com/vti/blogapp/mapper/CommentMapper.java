package com.vti.blogapp.mapper;

import com.vti.blogapp.dto.CommentDto;
import com.vti.blogapp.entity.Comment;
import com.vti.blogapp.form.CommentCreateForm;
import com.vti.blogapp.form.CommentUpdateForm;


public class CommentMapper {
    public static Comment map(CommentCreateForm form) {
        var comment = new Comment();
        var pk = new Comment.PrimaryKey();
        pk.setName(form.getName());
        pk.setEmail(form.getEmail());
        comment.setPk(pk);
        comment.setBody(form.getBody());
        return comment;
    }

    public static CommentDto map(Comment comment) {
        var dto = new CommentDto();
        dto.setPk(comment.getPk());
        dto.setBody(comment.getBody());
        dto.setCreatedAt(comment.getCreatedAt());
        dto.setUpdatedAt(comment.getUpdatedAt());
        return dto;
    }

    public static void map(CommentUpdateForm form, Comment comment) {
        var pk = new Comment.PrimaryKey();
        pk.setName(form.getName());
        pk.setEmail(form.getEmail());
        comment.setPk(pk);
        comment.setBody(form.getBody());
    }
}
