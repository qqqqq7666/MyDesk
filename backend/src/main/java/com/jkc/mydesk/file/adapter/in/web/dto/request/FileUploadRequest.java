package com.jkc.mydesk.file.adapter.in.web.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.web.multipart.MultipartFile;

public record FileUploadRequest(
        @NotNull(message = "폴더를 선택해주세요.")
        @Positive(message = "올바르지 않은 폴더 아이디입니다.")
        Long folderId,
        @NotNull(message = "업로드할 파일을 선택해주세요.")
        MultipartFile multipartFile
) {
}
