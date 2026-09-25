package com.jkc.mydesk.folder.adapter.in.dto.response;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record FolderSaveResponse(
        String name,
        LocalDateTime createdDate
) {
}