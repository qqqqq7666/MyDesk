package com.jkc.mydesk.post.application.service;

import com.jkc.mydesk.post.adapter.in.web.PostWebMapper;
import com.jkc.mydesk.post.adapter.in.web.dto.reqeust.PostSaveRequest;
import com.jkc.mydesk.post.adapter.in.web.dto.response.PostSaveResponse;
import com.jkc.mydesk.post.application.port.in.PostManagementUseCase;
import com.jkc.mydesk.post.application.port.out.PostRepository;
import com.jkc.mydesk.post.domain.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService implements PostManagementUseCase {
    private final PostRepository postRepository;

    @Override
    public Post save(Post request) {

        return postRepository.save(request);
    }
}
