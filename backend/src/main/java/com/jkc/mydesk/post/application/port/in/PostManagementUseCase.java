package com.jkc.mydesk.post.application.port.in;

import com.jkc.mydesk.post.adapter.in.web.dto.reqeust.PostSaveRequest;
import com.jkc.mydesk.post.adapter.in.web.dto.response.PostSaveResponse;

public interface PostManagementUseCase {
    PostSaveResponse save(PostSaveRequest request);
}
