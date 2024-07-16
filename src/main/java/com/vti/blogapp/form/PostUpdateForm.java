package com.vti.blogapp.form;

import com.vti.blogapp.entity.Post;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostUpdateForm {
    private String title;
    private String content;
    private String description;
    private Post.Status status;
}
