package com.com4in.testbackend.controller;

import com.com4in.testbackend.Repository.MemberRepository;
import com.com4in.testbackend.dto.MemberSignUpRequestDto;
import com.com4in.testbackend.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

import org.hibernate.loader.plan.spi.Join;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/member")
@Api(tags = {"회원가입 API"})
@RestController
public class MemberController {

    private final MemberService memberService;
    private final MemberRepository memberRepository;

    @PostMapping("/join")
    @ApiOperation(
            value = "회원가입"
            , notes = "사용자의 ID를 통해 사용자의 정보를 조회한다.")
    @ResponseStatus(HttpStatus.OK)
    public Long join(@Valid @RequestBody MemberSignUpRequestDto request) throws Exception {
        System.out.println("testset===========================================================================================");
        return memberService.signUp(request);
    }
}
