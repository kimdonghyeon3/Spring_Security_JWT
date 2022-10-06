package com.ll.exam.spring_security_jwt.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Util {

    public static class spring{

        public static <T> ResponseEntity<T> responseEntityOf(HttpHeaders headers){
            //HttpHeaders headers = new HttpHeaders();
            //headers.set("Authentication", "JWT-Token");
            //String body = "username : %s, password : %s".formatted(loginDto.getUsername(), loginDto.getPassword());

            return new ResponseEntity<>(null, headers, HttpStatus.OK);
        }

    }
}
