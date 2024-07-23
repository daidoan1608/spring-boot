package com.vti.blogapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "comment")
@IdClass(Comment.PrimaryKey.class)
public class Comment {
    @Id
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Id
    @Column(name = "email", length = 75, nullable = false)
    private String email;

    @Column(name = "body", length = 100, nullable = false)
    private String body;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    private Post post;

    @Setter
    @Getter
    @Embeddable
    public static class PrimaryKey implements Serializable {
        @Column(name = "name", length = 50, nullable = false)
        private String name;

        @Column(name = "email", length = 75, nullable = false)
        private String email;

    }
}