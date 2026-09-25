package com.jkc.mydesk.desk.adapter.in.web.dto.request;

import java.util.UUID;

public record DeskSaveRequest(
        String name,
        String description,
        UUID ownerId
) {
}
