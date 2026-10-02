package com.jkc.mydesk.post.adapter.in.web;

import com.jkc.mydesk.post.adapter.in.web.dto.reqeust.PostSaveRequest;
import com.jkc.mydesk.post.adapter.in.web.dto.reqeust.PostSearchRequest;
import com.jkc.mydesk.post.adapter.in.web.dto.response.PostSaveResponse;
import com.jkc.mydesk.post.adapter.in.web.dto.response.PostSearchResponse;
import com.jkc.mydesk.post.application.port.in.PostManagementUseCase;
import com.jkc.mydesk.post.application.port.in.PostQueryUseCase;
import com.jkc.mydesk.post.domain.model.Post;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts")
public class PostController {
    private final PostManagementUseCase managementUseCase;
    private final PostQueryUseCase queryUseCase;
    private final PostWebMapper webMapper;

    @PostMapping
    public ResponseEntity<PostSaveResponse> save(@Valid @RequestBody PostSaveRequest request) {
        Post post = managementUseCase.save(webMapper.toDomain(request));

        return ResponseEntity.created(URI.create("/temp"))
                .body(webMapper.toSaveResponse(post));
    }

    @GetMapping
    public ResponseEntity<PagedModel<PostSearchResponse>> search(
            @Valid @ModelAttribute PostSearchRequest request,
            @PageableDefault(size = 20) Pageable pageable
    ) {
        Page<Post> postPage = queryUseCase.search(request.folderId(), request.keyword(), pageable);

        return ResponseEntity.ok(new PagedModel<>(postPage.map(webMapper::toSearchResponse)));
    }
}
