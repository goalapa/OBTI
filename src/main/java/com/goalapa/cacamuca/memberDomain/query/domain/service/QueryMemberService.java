package com.goalapa.cacamuca.memberDomain.query.domain.service;

import com.goalapa.cacamuca.memberDomain.query.domain.aggregate.entity.Member;

public interface QueryMemberService {

    Boolean checkIsDuplicatedId(String memberId);

    Boolean checkIsDuplicatedEmail(String email);

    Member findId(String id);
}
