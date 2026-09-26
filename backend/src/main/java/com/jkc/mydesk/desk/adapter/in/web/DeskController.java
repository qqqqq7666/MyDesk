package com.jkc.mydesk.desk.adapter.in.web;

import com.jkc.mydesk.desk.adapter.in.web.dto.request.DeskSaveRequest;
import com.jkc.mydesk.desk.adapter.in.web.dto.response.DeskSaveResponse;
import com.jkc.mydesk.desk.application.service.DeskService;
import com.jkc.mydesk.desk.domain.model.Desk;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/desk")
public class DeskController {
    private final DeskService deskService;
    private final DeskWebMapper webMapper;

    @PostMapping
    public ResponseEntity<DeskSaveResponse> save(@RequestBody DeskSaveRequest request) {
        Desk savedDesk = deskService.save(webMapper.toDomain(request));

        return ResponseEntity.created(URI.create("/temp"))
                .body(webMapper.toSaveResponse(savedDesk));
    }
}
