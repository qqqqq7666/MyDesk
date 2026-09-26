package com.jkc.mydesk.user.adapter.in.web.dto.response;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record UserRegisterResponse(
        String email,
        LocalDateTime createdDate
) {
}
