package com.jkc.mydesk.user.adapter.in.web.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UserRegisterRequest(
        @Email(message = "올바른 이메일 형식이 아닙니다.")
        @Size(max = 320, message = "이메일은 320자 이하로 입력해주세요.")
        @NotBlank(message = "이메일을 입력해주세요.")
        String email,
        @Size(min = 8, max = 20, message = "비밀번호는 8자 이상 20자 이하로 입력해주세요.")
        @Pattern(
                regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,20}$",
                message = "비밀번호는 영문, 숫자, 특수문자를 모두 포함하여 8자 이상 20자 이하로 입력해주세요."
        )
        @NotBlank(message = "비밀번호를 입력해주세요.")
        String password,
        @NotBlank(message = "이름을 입력해주세요.")
        @Size(min = 2, max = 50, message = "이름은 2자 이상 50자 이하로 입력해주세요.")
        String name
) {
}
