package com.jkc.mydesk.folder.adapter.in.web.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record FolderSaveRequest(
        @NotBlank(message = "폴더 이름을 입력해주세요.")
        @Size(min = 1, max = 100, message = "폴더 이름은 1자 이상 100자 이하로 입력해주세요.")
        String name,
        @NotNull(message = "데스크를 선택해주세요.")
        @Positive(message = "올바르지 않은 데스크입니다.")
        Long deskId,
        @Positive(message = "올바르지 않은 상위 폴더입니다.")
        Long parentId
) {
}
