package com.jkc.mydesk.folder.adapter.in.web;

import com.jkc.mydesk.folder.adapter.in.web.dto.request.FolderSaveRequest;
import com.jkc.mydesk.folder.adapter.in.web.dto.response.FolderListResponse;
import com.jkc.mydesk.folder.adapter.in.web.dto.response.FolderSaveResponse;
import com.jkc.mydesk.folder.domain.model.Folder;
import org.springframework.stereotype.Component;

@Component
public class FolderWebMapper {
    public Folder toDomain(FolderSaveRequest request) {
        return Folder.builder()
                .name(request.name())
                .deskId(request.deskId())
                .parentId(request.parentId())
                .build();

    }

    public FolderSaveResponse toSaveResponse(Folder folder) {
        return FolderSaveResponse.builder()
                .name(folder.getName())
                .createdDate(folder.getCreatedDate())
                .build();
    }

    public FolderListResponse toListResponse(Folder folder) {
        return FolderListResponse.builder()
                .id(folder.getId())
                .name(folder.getName())
                .parentId(folder.getParentId())
                .build();
    }
}
