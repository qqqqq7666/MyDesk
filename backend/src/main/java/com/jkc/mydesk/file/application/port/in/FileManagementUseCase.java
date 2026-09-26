package com.jkc.mydesk.file.application.port.in;

import com.jkc.mydesk.file.domain.model.File;

import java.io.InputStream;

public interface FileManagementUseCase {
    File upload(File file, InputStream inputStream);
}
