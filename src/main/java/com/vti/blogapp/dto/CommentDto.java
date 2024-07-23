package com.vti.blogapp.dto;

import com.vti.blogapp.controller.CommentController;
import com.vti.blogapp.controller.PostController;
import com.vti.blogapp.entity.Comment;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Getter
@Setter
public class CommentDto extends RepresentationModel<CommentDto> {
    private Comment.PrimaryKey pk;
    private String body;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
