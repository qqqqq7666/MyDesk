package com.jkc.mydesk.file.adapter.in.web.dto.request;

import org.springframework.web.multipart.MultipartFile;

public record FileUploadRequest(
        Long folderId,
        MultipartFile multipartFile
) {
}
