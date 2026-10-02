package com.jkc.mydesk.post.adapter.in.web.dto.reqeust;

public record PostSearchRequest(
        Long folderId,
        String keyword
) {
}
