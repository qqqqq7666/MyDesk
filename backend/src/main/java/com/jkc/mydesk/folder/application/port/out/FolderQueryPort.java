package com.jkc.mydesk.folder.application.port.out;

import com.jkc.mydesk.folder.domain.model.Folder;

import java.util.List;
import java.util.UUID;

public interface FolderQueryPort {
    List<Folder> findFolderList(UUID userId, Long parentId);
}
