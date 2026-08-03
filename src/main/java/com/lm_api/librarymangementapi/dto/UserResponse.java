package com.lm_api.librarymangementapi.dto;

import lombok.Builder;


@Builder
public record UserResponse(
         Long id,
         String name,
         String email,
         String membershipStatus
) {
}
