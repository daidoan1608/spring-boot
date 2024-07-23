package com.vti.blogapp.specification;

import com.vti.blogapp.entity.Comment;
import com.vti.blogapp.entity.Post;
import com.vti.blogapp.form.CommentFilterForm;
import com.vti.blogapp.form.PostFilterForm;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.LinkedList;

public class CommentSpecification {
    public static Specification<Comment> buildSpec(CommentFilterForm form) {
        return form == null ? null : (root, query, builder) -> {
            var predicates = new LinkedList<Predicate>();

            var search = form.getSearch();
            if (StringUtils.hasText(search)) {
                var pattern = "%" + search.trim() + "%";
                var hasNameLike = builder.like(root.get("name"), pattern);
                var hasEmailLike = builder.like(root.get("email"), pattern);
                var predicate = builder.or(hasNameLike,hasEmailLike);
                predicates.add(predicate);
            }

            var postId = form.getPostId();
            if (postId != null) {
                var predicate = builder.equal(
                        root.get("post").get("id"),
                        postId
                );
                predicates.add(predicate);
            }

            var minCreateDate = form.getMinCreateDate();
            if (minCreateDate != null) {
                var minCreateAt = LocalDateTime.of(minCreateDate, LocalTime.MIN);
                var predicate = builder.greaterThanOrEqualTo(
                        root.get("createdAt"),
                        minCreateAt
                );
                predicates.add(predicate);
            }

            var maxCreateDate = form.getMaxCreateDate();
            if (maxCreateDate != null) {
                var maxCreateAt = LocalDateTime.of(maxCreateDate, LocalTime.MAX);
                var predicate = builder.lessThanOrEqualTo(
                        root.get("createdAt"),
                        maxCreateAt
                );
                predicates.add(predicate);
            }

            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
}

