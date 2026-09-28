package com.jkc.mydesk.folder.application.port.out;

import com.jkc.mydesk.folder.domain.model.Folder;

public interface FolderPort {
    Folder save(Folder folder);
}
