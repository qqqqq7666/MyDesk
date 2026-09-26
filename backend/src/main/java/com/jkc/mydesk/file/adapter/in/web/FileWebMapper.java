package com.jkc.mydesk.file.adapter.in.web;

import com.jkc.mydesk.file.adapter.in.web.dto.request.FileUploadRequest;
import com.jkc.mydesk.file.adapter.in.web.dto.response.FileUploadResponse;
import com.jkc.mydesk.file.domain.model.File;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class FileWebMapper {

    public File toDomain(FileUploadRequest request) {
        String objectKey = "files/" + UUID.randomUUID();

        return File.builder()
                .folderId(request.folderId())
                .originalName(request.multipartFile().getOriginalFilename())
                .objectKey(objectKey)
                .contentType(request.multipartFile().getContentType())
                .size(request.multipartFile().getSize())
                .build();
    }

    public FileUploadResponse toUploadResponse(File file) {
        return FileUploadResponse.builder()
                .name(file.getOriginalName())
                .objectKey(file.getObjectKey())
                .createdDate(file.getCreatedDate())
                .build();
    }
}
