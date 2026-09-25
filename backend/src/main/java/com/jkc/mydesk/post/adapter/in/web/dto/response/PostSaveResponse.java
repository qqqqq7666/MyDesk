package com.jkc.mydesk.post.adapter.in.web.dto.response;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record PostSaveResponse(
        String title,
        LocalDateTime createdDate
) {
}
