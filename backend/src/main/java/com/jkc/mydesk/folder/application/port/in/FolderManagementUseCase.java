package com.jkc.mydesk.folder.application.port.in;

import com.jkc.mydesk.folder.adapter.in.dto.request.FolderSaveRequest;
import com.jkc.mydesk.folder.adapter.in.dto.response.FolderSaveResponse;

public interface FolderManagementUseCase {
    FolderSaveResponse save(FolderSaveRequest request);
}
