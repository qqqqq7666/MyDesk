package com.jkc.mydesk.folder.adapter.in.dto.request;

public record FolderSaveRequest(
        String name,
        Long deskId,
        Long parentId
) {
}
