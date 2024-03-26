package com.demo.blog.model;

import jakarta.validation.constraints.NotEmpty;

public record Post(
        Integer id,
        Integer userId,
        @NotEmpty
        String title,
        String body) {
}
