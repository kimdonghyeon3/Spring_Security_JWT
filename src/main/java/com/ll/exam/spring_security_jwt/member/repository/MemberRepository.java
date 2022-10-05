package com.ll.exam.spring_security_jwt.member.repository;

import com.ll.exam.spring_security_jwt.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByUsername(String username);
}
