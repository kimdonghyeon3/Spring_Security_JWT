package com.ll.exam.spring_security_jwt.app.article.controller;

import com.ll.exam.spring_security_jwt.app.article.entity.Article;
import com.ll.exam.spring_security_jwt.app.article.service.ArticleService;
import com.ll.exam.spring_security_jwt.app.base.dto.RsData;
import com.ll.exam.spring_security_jwt.util.Util;
import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping("/articles")
@RequiredArgsConstructor
public class ArticlesController {
    private final ArticleService articleService;

    @GetMapping("")
    public ResponseEntity<RsData> list() {
        List<Article> articles = articleService.findAll();

        return Util.spring.responseEntityOf(
                RsData.successOf(
                        Util.mapOf(
                                "articles", articles
                        )
                )
        );
    }
}
