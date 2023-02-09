package com.com4in.testbackend.dto;

import com.com4in.testbackend.model.Member;
import com.com4in.testbackend.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
public class MemberSignUpRequestDto {

    @NotBlank(message = "아이디를 입력해주세요")
    private String email;

    @NotBlank(message = "닉네임을 입력해주세요.")
    @Size(min=2, message = "닉네임이 너무 짧습니다.")
    private String nickname;

    @NotNull(message = "나이를 입력해주세요")
    @Range(min = 0, max = 150)
    private int age;

    @NotBlank(message = "비밀번호를 입력해주세요")
    private String password;

    private Role role;

    @Builder
    public Member toEntity(){
        return Member.builder()
                .email(email)
                .nickname(nickname)
                .age(age)
                .password(password)
                .role(Role.USER)
                .build();
    }
}