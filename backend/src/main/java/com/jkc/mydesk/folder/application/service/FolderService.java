package com.jkc.mydesk.folder.application.service;

import com.jkc.mydesk.folder.application.port.in.FolderManagementUseCase;
import com.jkc.mydesk.folder.application.port.out.FolderPort;
import com.jkc.mydesk.folder.domain.model.Folder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FolderService implements FolderManagementUseCase {
    private final FolderPort folderPort;

    @Override
    public Folder save(Folder request) {
        return folderPort.save(request);
    }
}
