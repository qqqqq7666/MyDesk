package com.jkc.mydesk.post.application.port.in;

import com.jkc.mydesk.post.domain.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostQueryUseCase {
    Page<Post> search(Long folderId, String keyword, Pageable pageable);
}
