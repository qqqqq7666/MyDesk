package com.jkc.mydesk.desk.adapter.in.web.dto.response;

import lombok.Builder;

@Builder
public record DeskListResponse(
        String name,
        String description
) {
}
