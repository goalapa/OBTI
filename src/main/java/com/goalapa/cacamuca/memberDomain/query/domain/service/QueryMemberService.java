package com.goalapa.cacamuca.memberDomain.query.domain.service;

public interface QueryMemberService {

    Boolean checkIsDuplicatedId(String memberId);

    Boolean checkIsDuplicatedEmail(String email);
}
