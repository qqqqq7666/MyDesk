package com.jkc.mydesk.post.application.service;

import com.jkc.mydesk.post.application.port.in.PostManagementUseCase;
import com.jkc.mydesk.post.application.port.in.PostQueryUseCase;
import com.jkc.mydesk.post.application.port.out.PostPort;
import com.jkc.mydesk.post.application.port.out.PostQueryPort;
import com.jkc.mydesk.post.domain.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService implements
        PostManagementUseCase,
        PostQueryUseCase {

    private final PostPort postPort;
    private final PostQueryPort postQueryPort;

    @Override
    public Post save(Post request) {

        return postPort.save(request);
    }

    @Override
    public Page<Post> search(Long folderId, String keyword, Pageable pageable) {
        return postQueryPort.search(folderId, keyword, pageable);
    }
}
