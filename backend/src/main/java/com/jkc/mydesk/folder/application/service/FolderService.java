package com.jkc.mydesk.folder.application.service;

import com.jkc.mydesk.folder.adapter.in.dto.request.FolderSaveRequest;
import com.jkc.mydesk.folder.adapter.in.dto.response.FolderSaveResponse;
import com.jkc.mydesk.folder.application.port.in.FolderManagementUseCase;
import com.jkc.mydesk.folder.application.port.out.FolderRepository;
import com.jkc.mydesk.folder.domain.model.Folder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FolderService implements FolderManagementUseCase {
    private final FolderRepository folderRepository;

    @Override
    public FolderSaveResponse save(FolderSaveRequest request) {
        Folder folder = Folder.builder()
                .name(request.name())
                .deskId(request.deskId())
                .parentId(request.parentId())
                .build();

        Folder savedFolder = folderRepository.save(folder);

        return FolderSaveResponse.builder()
                .name(savedFolder.getName())
                .createdDate(savedFolder.getCreatedDate())
                .build();
    }
}
