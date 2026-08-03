package com.lm_api.librarymangementapi.dto;


import jakarta.validation.constraints.NotNull;

public record LoanRequest(
        @NotNull(message = "user id is compulsory")
        Long userId,
        @NotNull(message = "Book id is compulsory")
        Long bookId
) {
}
