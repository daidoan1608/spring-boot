package com.vti.blogapp.dto;

import com.vti.blogapp.entity.Post;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PostDto {
    private Long id;
    private String title;
    private String content;
    private String description;
    private Post.Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
