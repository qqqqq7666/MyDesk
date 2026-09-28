package com.jkc.mydesk.folder.application.service;

import com.jkc.mydesk.folder.application.port.in.FolderManagementUseCase;
import com.jkc.mydesk.folder.application.port.in.FolderQueryUseCase;
import com.jkc.mydesk.folder.application.port.out.FolderPort;
import com.jkc.mydesk.folder.application.port.out.FolderQueryPort;
import com.jkc.mydesk.folder.domain.model.Folder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FolderService implements
        FolderManagementUseCase,
        FolderQueryUseCase {

    private final FolderPort folderPort;
    private final FolderQueryPort folderQueryPort;

    @Override
    public Folder save(Folder request) {
        return folderPort.save(request);
    }

    @Override
    public List<Folder> getFolderList(UUID userId, Long parentId) {
        return folderQueryPort.findFolderList(userId, parentId);
    }
}
