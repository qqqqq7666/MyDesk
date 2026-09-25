package com.jkc.mydesk.post.adapter.in.web;

import com.jkc.mydesk.post.adapter.in.web.dto.reqeust.PostSaveRequest;
import com.jkc.mydesk.post.adapter.in.web.dto.response.PostSaveResponse;
import com.jkc.mydesk.post.domain.model.Post;
import org.springframework.stereotype.Component;

@Component
public class PostWebMapper {
    public Post toCommand(PostSaveRequest request) {
        return Post.builder()
                .title(request.title())
                .folderId(request.folderId())
                .content(request.content())
                .build();
    }

    public PostSaveResponse toSaveResponse(Post post) {
        return PostSaveResponse.builder()
                .title(post.getTitle())
                .createdDate(post.getCreatedDate())
                .build();
    }
}
