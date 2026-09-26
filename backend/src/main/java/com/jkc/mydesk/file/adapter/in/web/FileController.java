package com.jkc.mydesk.file.adapter.in.web;

import com.jkc.mydesk.file.adapter.in.web.dto.request.FileUploadRequest;
import com.jkc.mydesk.file.adapter.in.web.dto.response.FileUploadResponse;
import com.jkc.mydesk.file.application.port.in.FileManagementUseCase;
import com.jkc.mydesk.file.domain.model.File;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/files")
public class FileController {
    private final FileManagementUseCase managementUseCase;
    private final FileWebMapper webMapper;

    // TODO Custom Exception 생성 IOException 대신 명확하게
    @PostMapping
    public ResponseEntity<FileUploadResponse> upload(
            @ModelAttribute FileUploadRequest request
    ) throws IOException {
        File fileModel = webMapper.toDomain(request);

        return ResponseEntity.created(URI.create("/temp"))
                .body(webMapper.toUploadResponse(managementUseCase.upload(fileModel, request.multipartFile().getInputStream())));
    }
}
