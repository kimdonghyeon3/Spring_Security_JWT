package com.ll.exam.spring_security_jwt.member.dto;

import lombok.Data;

@Data
public class LoginDto {
    private String username;
    private String password;
}
