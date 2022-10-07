package com.ll.exam.spring_security_jwt.app.article.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Article {

    @Id
    private Long id;
}
