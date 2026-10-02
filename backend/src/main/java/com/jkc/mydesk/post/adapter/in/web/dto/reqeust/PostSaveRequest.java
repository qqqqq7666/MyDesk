package com.jkc.mydesk.post.adapter.in.web.dto.reqeust;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record PostSaveRequest(
        @Size(min = 1, max = 200, message = "제목은 1자 이상 200자 이하로 입력해주세요.")
        @NotBlank(message = "제목을 입력해주세요.")
        String title,
        @NotNull(message = "폴더를 선택해주세요.")
        @Positive(message = "올바르지 않은 폴더입니다.")
        Long folderId,
        @Size(max = 100_000, message = "본문은 100,000자 이하로 입력해주세요.")
        @NotNull(message = "본문을 입력해주세요.")
        String content
) {
}
