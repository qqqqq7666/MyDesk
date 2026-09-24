package com.jkc.mydesk.user.adapter.in.web.dto.response;

import java.time.LocalDateTime;

public record UserRegisterResponse(
        String email,
        LocalDateTime createdDate
) {
}
