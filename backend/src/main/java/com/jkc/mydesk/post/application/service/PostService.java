package com.jkc.mydesk.post.application.service;

import com.jkc.mydesk.post.application.port.in.PostManagementUseCase;
import com.jkc.mydesk.post.application.port.out.PostPort;
import com.jkc.mydesk.post.domain.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService implements PostManagementUseCase {
    private final PostPort postPort;

    @Override
    public Post save(Post request) {

        return postPort.save(request);
    }
}
