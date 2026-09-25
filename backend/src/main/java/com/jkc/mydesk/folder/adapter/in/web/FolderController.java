package com.jkc.mydesk.folder.adapter.in.web;

import com.jkc.mydesk.folder.adapter.in.dto.request.FolderSaveRequest;
import com.jkc.mydesk.folder.adapter.in.dto.response.FolderSaveResponse;
import com.jkc.mydesk.folder.application.service.FolderService;
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

    @PostMapping
    public ResponseEntity<FolderSaveResponse> save(FolderSaveRequest request) {
        return ResponseEntity.created(URI.create("/temp"))
                .body(folderService.save(request));
    }
}
