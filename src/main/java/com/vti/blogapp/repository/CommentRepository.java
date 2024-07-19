package com.vti.blogapp.repository;

import com.vti.blogapp.dto.CommentDto;
import com.vti.blogapp.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface CommentRepository extends
        JpaRepository<Comment, String> {
    //Method name
    Page<Comment> findByPostId(Long postId, Pageable pageable);

    //Query methods
    @Query("DELETE FROM Comment WHERE email = :email")
    @Modifying
    void deleteByEmail(@Param("email") String email);

    @Query("DELETE FROM Comment WHERE name = ?1 AND email = ?2")
    void deleteByName(String name, String email);

}
