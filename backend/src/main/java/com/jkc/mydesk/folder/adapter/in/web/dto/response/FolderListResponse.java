package com.jkc.mydesk.folder.adapter.in.web.dto.response;

import lombok.Builder;

@Builder
public record FolderListResponse(
        Long id,
        String name,
        Long parentId
) {
}
