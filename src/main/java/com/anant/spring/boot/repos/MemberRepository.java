package com.anant.spring.boot.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anant.spring.boot.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
