package com.vti.blogapp.converter;

import com.vti.blogapp.entity.Post;
import jakarta.persistence.AttributeConverter;

public class PostStatusConverter implements AttributeConverter<Post.Status, Character> {
    @Override
    public Character convertToDatabaseColumn(Post.Status status) {
        return status.toString().charAt(0);
    }

    @Override
    public Post.Status convertToEntityAttribute(Character code) {
        if (code == 'O') {
            return Post.Status.OPENING;
        } else if (code == 'C') {
            return Post.Status.CLOSING;
        }
        throw new IllegalArgumentException(code.toString());
    }
}
