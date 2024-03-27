package com.demo.blog.model;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;

public record Post(
        @Id
        Integer id,
        Integer userId,
        @NotEmpty
        String title,
        String body) {
}
