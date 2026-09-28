package com.jkc.mydesk.folder.adapter.in.web;

import com.jkc.mydesk.folder.adapter.in.web.dto.request.FolderSaveRequest;
import com.jkc.mydesk.folder.adapter.in.web.dto.response.FolderListResponse;
import com.jkc.mydesk.folder.adapter.in.web.dto.response.FolderSaveResponse;
import com.jkc.mydesk.folder.application.port.in.FolderManagementUseCase;
import com.jkc.mydesk.folder.application.port.in.FolderQueryUseCase;
import com.jkc.mydesk.folder.domain.model.Folder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/folders")
public class FolderController {
    private final FolderWebMapper webMapper;
    private final FolderManagementUseCase managementUseCase;
    private final FolderQueryUseCase queryUseCase;

    @PostMapping
    public ResponseEntity<FolderSaveResponse> save(FolderSaveRequest request) {
        Folder folder = managementUseCase.save(webMapper.toDomain(request));

        return ResponseEntity.created(URI.create("/temp"))
                .body(webMapper.toSaveResponse(folder));
    }

    @GetMapping
    public ResponseEntity<List<FolderListResponse>> getFolderList(@RequestParam(required = false) Long parentId) {
        // mockup
        UUID mockUserId = UUID.randomUUID();
        List<Folder> folderList = queryUseCase.getFolderList(mockUserId, parentId);

        return ResponseEntity.ok(
                folderList.stream()
                        .map(webMapper::toListResponse)
                        .toList()
        );
    }
}
