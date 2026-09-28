package com.jkc.mydesk.folder.application.port.in;

import com.jkc.mydesk.folder.domain.model.Folder;

import java.util.List;
import java.util.UUID;

public interface FolderQueryUseCase {
    List<Folder> getFolderList(UUID userId, Long parentId);
}
