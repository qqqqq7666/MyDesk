package com.jkc.mydesk.folder.adapter.in.web;

import com.jkc.mydesk.folder.adapter.in.web.dto.request.FolderSaveRequest;
import com.jkc.mydesk.folder.adapter.in.web.dto.response.FolderSaveResponse;
import com.jkc.mydesk.folder.application.service.FolderService;
import com.jkc.mydesk.folder.domain.model.Folder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/folders")
public class FolderController {
    private final FolderService folderService;
    private final FolderWebMapper webMapper;

    @PostMapping
    public ResponseEntity<FolderSaveResponse> save(FolderSaveRequest request) {
        Folder folder = folderService.save(webMapper.toDomain(request));

        return ResponseEntity.created(URI.create("/temp"))
                .body(webMapper.toSaveResponse(folder));
    }
}
