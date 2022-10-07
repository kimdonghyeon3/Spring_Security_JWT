package com.ll.exam.spring_security_jwt.app.article.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ll.exam.spring_security_jwt.app.base.entity.BaseEntity;
import com.ll.exam.spring_security_jwt.app.member.entity.Member;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class Article extends BaseEntity {
    @ManyToOne
    private Member author;
    @Column(unique = true)
    private String subject;
    @JsonIgnore
    private String content;

    public Article(long id) {
        super(id);
    }
}