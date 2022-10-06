package com.ll.exam.spring_security_jwt.member.controller;


import com.ll.exam.spring_security_jwt.base.RsData;
import com.ll.exam.spring_security_jwt.member.dto.LoginDto;
import com.ll.exam.spring_security_jwt.member.entity.Member;
import com.ll.exam.spring_security_jwt.member.service.MemberService;
import com.ll.exam.spring_security_jwt.util.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<RsData> login(@RequestBody LoginDto loginDto) {
        if (loginDto.isNotValid()) {
            return Util.spring.responseEntityOf(RsData.of("F-1", "로그인 정보가 올바르지 않습니다."));
        }

        Member member = memberService.findByUsername(loginDto.getUsername()).orElse(null);

        if (member == null) {
            return Util.spring.responseEntityOf(RsData.of("F-2", "일치하는 회원이 존재하지 않습니다."));
        }

        if (passwordEncoder.matches(loginDto.getPassword(), member.getPassword()) == false) {
            return Util.spring.responseEntityOf(RsData.of("F-3", "비밀번호가 일치하지 않습니다."));
        }

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authentication", "JWT_Access_Token");

        Map<String, String> map = new HashMap<>();
        map.put("accessToken", "JWT_Access_Token");

        return Util.spring.responseEntityOf(RsData.of("S-1", "로그인 성공, Access Token을 발급합니다.", map), headers);
    }

}
