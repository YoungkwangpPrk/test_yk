package com.com4in.testbackend.service;

import com.com4in.testbackend.dto.MemberSignUpRequestDto;

public interface MemberService {

    // 회원가입
    public Long signUp(MemberSignUpRequestDto requestDto) throws Exception;
}