package com.jkc.mydesk.file.adapter.in.web.dto.response;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record FileUploadResponse(
        String name,
        String objectKey,
        LocalDateTime createdDate
) {
}
