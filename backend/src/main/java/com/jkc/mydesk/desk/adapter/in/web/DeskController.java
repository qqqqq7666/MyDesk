package com.jkc.mydesk.desk.adapter.in.web;

import com.jkc.mydesk.desk.adapter.in.web.dto.request.DeskSaveRequest;
import com.jkc.mydesk.desk.adapter.in.web.dto.response.DeskSaveResponse;
import com.jkc.mydesk.desk.application.service.DeskService;
import com.jkc.mydesk.user.adapter.out.persistence.UserJpaEntity;
import com.jkc.mydesk.user.adapter.out.persistence.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/desk")
public class DeskController {
    private final DeskService deskService;
    private final UserJpaRepository repository;

    @PostMapping
    public ResponseEntity<DeskSaveResponse> save(@RequestBody DeskSaveRequest request) {
        UserJpaEntity mockup = repository.findById(UUID.fromString("3ed4a118-890c-4b22-aaf5-241ad3e11068"))
                .orElseThrow();
        return ResponseEntity.created(URI.create("/temp"))
                .body(deskService.save(request, mockup));
    }
}
