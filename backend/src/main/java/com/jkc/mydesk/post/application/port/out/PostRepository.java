package com.jkc.mydesk.post.application.port.out;

import com.jkc.mydesk.post.domain.model.Post;

public interface PostRepository {
    Post save(Post post);
}
