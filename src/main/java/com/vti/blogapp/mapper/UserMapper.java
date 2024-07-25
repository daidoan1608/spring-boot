package com.vti.blogapp.mapper;

import com.vti.blogapp.dto.UserDto;
import com.vti.blogapp.entity.User;
import com.vti.blogapp.form.UserCreateForm;

public class UserMapper {
    public static User map(UserCreateForm form) {
        var user = new User();
        user.setName(form.getName());
        user.setUsername(form.getUsername());
        user.setPassword(form.getPassword());
        user.setEmail(form.getEmail());
        return user;
    }

    public static UserDto map(User user) {
        var dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        dto.setRole(user.getRole());
        dto.setCreatedAt(user.getCreatedAt());
        dto.setUpdatedAt(user.getUpdatedAt());
        return dto;
    }
}
