package com.ll.exam.spring_security_jwt.member.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {

    @RequestMapping("/member/login")
    @ResponseBody
    public String login(){
        return "hello";
    }
}
