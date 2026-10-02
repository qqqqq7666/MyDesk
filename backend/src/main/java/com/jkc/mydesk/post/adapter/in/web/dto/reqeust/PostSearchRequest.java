package com.jkc.mydesk.post.adapter.in.web.dto.reqeust;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record PostSearchRequest(
        @Positive(message = "올바르지 않은 폴더입니다.")
        Long folderId,
        @Size(max = 100, message = "검색어는 100자 이하로 입력해주세요.")
        String keyword
) {
}
