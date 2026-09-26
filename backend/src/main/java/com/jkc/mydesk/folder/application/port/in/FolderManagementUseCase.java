package com.jkc.mydesk.folder.application.port.in;

import com.jkc.mydesk.folder.domain.model.Folder;

public interface FolderManagementUseCase {
    Folder save(Folder request);
}
