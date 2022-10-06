package com.ll.exam.spring_security_jwt.member.controller;


import com.ll.exam.spring_security_jwt.member.dto.LoginDto;
import com.ll.exam.spring_security_jwt.member.entity.Member;
import com.ll.exam.spring_security_jwt.member.service.MemberService;
import com.ll.exam.spring_security_jwt.util.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto, HttpServletResponse response){

        if(loginDto.isNotValid()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


        Member member = memberService.findByUsername(loginDto.getUsername()).orElse(null);

        if(member == null){
            return new ResponseEntity<>(null, null, HttpStatus.BAD_REQUEST);
        }

        if(passwordEncoder.matches(loginDto.getPassword(), member.getPassword()) == false){
            return new ResponseEntity<>(null, null, HttpStatus.BAD_REQUEST);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authentication", "JWT-Token");


        return Util.spring.responseEntityOf(headers);
    }
}
