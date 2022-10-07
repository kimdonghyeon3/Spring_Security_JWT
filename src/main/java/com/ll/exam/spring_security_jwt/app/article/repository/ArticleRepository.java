package com.ll.exam.spring_security_jwt.app.article.repository;

import com.ll.exam.spring_security_jwt.app.article.entity.Article;
import com.ll.exam.spring_security_jwt.app.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
