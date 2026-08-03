package com.lm_api.librarymangementapi.dto;

import lombok.Builder;

import java.time.LocalDate;
@Builder
public record LoanResponse(
        Long id,
        Long UserId,
        Long bookId,
        LocalDate borrowDate,
        LocalDate returnDate
) {
}
