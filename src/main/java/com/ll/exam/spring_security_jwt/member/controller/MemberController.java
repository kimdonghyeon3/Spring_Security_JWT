package com.ll.exam.spring_security_jwt.member.controller;


import com.ll.exam.spring_security_jwt.member.dto.LoginDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class MemberController {

    @RequestMapping("/member/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto, HttpServletResponse response){

        response.addHeader("Authentication","myToken");

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authentication", "token");
        String body = "username : %s, password : %s".formatted(loginDto.getUsername(), loginDto.getPassword());

        return new ResponseEntity<>(body, headers, HttpStatus.OK);
    }
}
