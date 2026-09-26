package com.jkc.mydesk.post.adapter.in.web;

import com.jkc.mydesk.post.adapter.in.web.dto.reqeust.PostSaveRequest;
import com.jkc.mydesk.post.adapter.in.web.dto.response.PostSaveResponse;
import com.jkc.mydesk.post.application.port.in.PostManagementUseCase;
import com.jkc.mydesk.post.domain.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts")
public class PostController {
    private final PostManagementUseCase managementUseCase;
    private final PostWebMapper webMapper;

    @PostMapping
    public ResponseEntity<PostSaveResponse> save(@RequestBody PostSaveRequest request) {
        Post post = managementUseCase.save(webMapper.toDomain(request));

        return ResponseEntity.created(URI.create("/temp"))
                .body(webMapper.toSaveResponse(post));
    }
}
