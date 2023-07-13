package com.goalapa.cacamuca.memberDomain.query.application.service;

import com.goalapa.cacamuca.memberDomain.query.domain.aggregate.entity.Member;
import com.goalapa.cacamuca.memberDomain.query.domain.repository.MemberMapper;
import com.goalapa.cacamuca.memberDomain.query.domain.service.QueryMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class QueryMemberServiceImpl implements QueryMemberService {

    private final MemberMapper memberMapper;

    @Override
    public Boolean checkIsDuplicatedId(String memberId) {

        Member member = memberMapper.findByMemberId(memberId);

        if(member == null) {
            return true;
        } else {
            return false;
        }
    }
}
