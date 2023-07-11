package com.goalapa.cacamuca.memberDomain.command.domain.repository;

import com.goalapa.cacamuca.memberDomain.command.domain.aggregate.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

}