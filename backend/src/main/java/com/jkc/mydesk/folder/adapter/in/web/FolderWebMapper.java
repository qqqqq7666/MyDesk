package com.jkc.mydesk.folder.adapter.in.web;

import com.jkc.mydesk.desk.adapter.in.web.dto.request.DeskSaveRequest;
import com.jkc.mydesk.desk.adapter.in.web.dto.response.DeskSaveResponse;
import com.jkc.mydesk.desk.domain.model.Desk;
import com.jkc.mydesk.folder.adapter.in.web.dto.request.FolderSaveRequest;
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
}
