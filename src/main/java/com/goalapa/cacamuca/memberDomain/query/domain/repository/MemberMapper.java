package com.goalapa.cacamuca.memberDomain.query.domain.repository;

import com.goalapa.cacamuca.memberDomain.query.domain.aggregate.entity.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    Member findByMemberId(String memberId);

    Member getMember(String memberId);

    Member findByMemberEmail(String email);

    List<Member> findMembers();
}
