package com.vti.blogapp.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class PostCreateForm {
    @NotBlank(message = "Post title must not be blank") //Khac null va khac dau cach
    @Length(max = 100, message = "Post title must not be more than 100 characters")
    private String title;

    @NotBlank
    @Length(max = 150)
    private String content;

    @NotBlank
    @Length(max = 100)
    private String description;

    @NotNull
    @Pattern(regexp = "OPENING|CLOSING", message = "Post status must be OPENING or CLOSING")
    private String status;
}
