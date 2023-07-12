package com.goalapa.cacamuca.memberDomain.command.domain.repository;

import com.goalapa.cacamuca.memberDomain.command.domain.aggregate.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
    Optional<Member> findByMemberId(String userId);
}