package com.jkc.mydesk.post.adapter.in.web.dto.reqeust;

public record PostSaveRequest(
        String title,
        Long folderId,
        String content
) {
}
