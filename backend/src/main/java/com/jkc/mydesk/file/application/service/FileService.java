package com.jkc.mydesk.file.application.service;

import com.jkc.mydesk.file.adapter.in.web.FileWebMapper;
import com.jkc.mydesk.file.adapter.in.web.dto.request.FileUploadRequest;
import com.jkc.mydesk.file.adapter.in.web.dto.response.FileUploadResponse;
import com.jkc.mydesk.file.application.port.in.FileManagementUseCase;
import com.jkc.mydesk.file.application.port.out.FileRepository;
import com.jkc.mydesk.file.domain.model.File;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.InputStream;

@Service
@RequiredArgsConstructor
public class FileService implements FileManagementUseCase {
    private final FileRepository fileRepository;

    // TODO 일단 서버에서 구현만 해두고 Presigned로 변경
    @Override
    public File upload(File file, InputStream inputStream) {
        return fileRepository.upload(file, inputStream);
    }
}
