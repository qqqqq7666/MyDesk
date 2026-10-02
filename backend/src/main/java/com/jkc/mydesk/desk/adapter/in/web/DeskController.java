package com.jkc.mydesk.desk.adapter.in.web;

import com.jkc.mydesk.desk.adapter.in.web.dto.request.DeskSaveRequest;
import com.jkc.mydesk.desk.adapter.in.web.dto.response.DeskListResponse;
import com.jkc.mydesk.desk.adapter.in.web.dto.response.DeskSaveResponse;
import com.jkc.mydesk.desk.application.port.in.DeskManagementUseCase;
import com.jkc.mydesk.desk.application.port.in.DeskQueryUseCase;
import com.jkc.mydesk.desk.domain.model.Desk;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/desk")
public class DeskController {
    private final DeskWebMapper webMapper;
    private final DeskManagementUseCase managementUseCase;
    private final DeskQueryUseCase queryUseCase;

    @PostMapping
    public ResponseEntity<DeskSaveResponse> save(@Valid @RequestBody DeskSaveRequest request) {
        Desk savedDesk = managementUseCase.save(webMapper.toDomain(request));

        return ResponseEntity.created(URI.create("/temp"))
                .body(webMapper.toSaveResponse(savedDesk));
    }

    @GetMapping
    public ResponseEntity<List<DeskListResponse>> getDeskList(@RequestParam UUID ownerId) {
        List<Desk> deskList = queryUseCase.getDeskListByOwnerId(ownerId);

        return ResponseEntity.ok(deskList.stream()
                .map(webMapper::toListResponse)
                .toList()
        );
    }
}
