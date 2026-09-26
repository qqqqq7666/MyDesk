package com.jkc.mydesk.folder.application.service;

import com.jkc.mydesk.folder.adapter.in.web.dto.request.FolderSaveRequest;
import com.jkc.mydesk.folder.adapter.in.web.dto.response.FolderSaveResponse;
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
    public Folder save(Folder request) {
        return folderRepository.save(request);
    }
}
