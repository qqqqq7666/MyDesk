package com.jkc.mydesk.desk.adapter.in.web.dto.response;

import lombok.Builder;

@Builder
public record DeskListResponse(
        Long id,
        String name,
        String description
) {
}
