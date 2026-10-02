package com.jkc.mydesk.desk.adapter.in.web.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record DeskSaveRequest(
        @NotBlank(message = "데스크 이름을 입력해주세요.")
        @Size(max = 100, message = "데스크 이름은 100자 이하로 입력해주세요.")
        String name,
        @Size(max = 255, message = "데스크 설명은 255자 이하로 입력해주세요.")
        String description,
        // TODO 인증 적용 후 토큰에서 추출하도록 변경
        @NotNull(message = "소유자 정보가 없습니다.")
        UUID ownerId
) {
}
