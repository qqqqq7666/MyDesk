package com.jkc.mydesk.desk.adapter.in.web.dto.response;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record DeskSaveResponse(
        String name,
        LocalDateTime createdDate
) {
}
