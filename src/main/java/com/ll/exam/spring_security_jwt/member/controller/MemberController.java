package com.ll.exam.spring_security_jwt.member.controller;


import com.ll.exam.spring_security_jwt.member.dto.LoginDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class MemberController {

    @RequestMapping("/member/login")
    public String login(@RequestBody LoginDto loginDto, HttpServletResponse response){

        response.addHeader("Authentication","myToken");

        return "username : %s, password : %s".formatted(loginDto.getUsername(), loginDto.getPassword());
    }
}
