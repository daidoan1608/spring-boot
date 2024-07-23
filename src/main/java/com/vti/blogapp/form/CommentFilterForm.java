package com.vti.blogapp.form;

import com.vti.blogapp.entity.Post;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CommentFilterForm {
    private String search;
    private Long postId;
    private LocalDate minCreateDate;
    private LocalDate maxCreateDate;
}
