package com.jkc.mydesk.file.application.service;

import com.jkc.mydesk.file.application.port.in.FileManagementUseCase;
import com.jkc.mydesk.file.application.port.out.FilePort;
import com.jkc.mydesk.file.domain.model.File;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
@RequiredArgsConstructor
public class FileService implements FileManagementUseCase {
    private final FilePort filePort;

    // TODO 일단 서버에서 구현만 해두고 Presigned로 변경
    @Override
    public File upload(File file, InputStream inputStream) {
        return filePort.upload(file, inputStream);
    }
}
