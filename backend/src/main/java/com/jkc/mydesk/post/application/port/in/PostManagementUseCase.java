package com.jkc.mydesk.post.application.port.in;

import com.jkc.mydesk.post.domain.model.Post;

public interface PostManagementUseCase {
    Post save(Post request);
}
