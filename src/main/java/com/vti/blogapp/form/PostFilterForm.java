package com.vti.blogapp.form;

import com.vti.blogapp.entity.Post;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PostFilterForm {
    private String search;
    private LocalDate minCreateDate;
    private LocalDate maxCreateDate;
    private Post.Status status;
}
