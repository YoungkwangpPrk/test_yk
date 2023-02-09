package com.com4in.testbackend.service;

import com.com4in.testbackend.Repository.MemberRepository;
import com.com4in.testbackend.dto.MemberSignUpRequestDto;
import com.com4in.testbackend.dto.response.Response;
import com.com4in.testbackend.model.Member;
import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    @Override
    public Long signUp(MemberSignUpRequestDto requestDto) throws Exception {

        if (memberRepository.findByEmail(requestDto.getEmail()).isPresent()){
            throw new Exception("이미 존재하는 이메일입니다.");
        }

        if (!requestDto.getPassword().equals(requestDto.getPassword())){
            throw new Exception("비밀번호가 일치하지 않습니다.");
        }

        Member member = memberRepository.save(requestDto.toEntity());
//        member.encodePassword(passwordEncoder);

//        member.addUserAuthority();
        return member.getId();
    }
}