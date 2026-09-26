package com.jkc.mydesk.folder.adapter.in.web.dto.request;

public record FolderSaveRequest(
        String name,
        Long deskId,
        Long parentId
) {
}
