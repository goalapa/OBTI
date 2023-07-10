package com.goalapa.cacamuca.memberDomain.command.model.service;

import com.goalapa.cacamuca.memberDomain.command.domain.aggregate.entity.Member;
import com.goalapa.cacamuca.memberDomain.command.model.Mapper.MemberMapper;
import com.goalapa.cacamuca.memberDomain.command.model.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    public List<Member> getMemberList() {

        List<Member> member = memberRepository.findAll();

        return member;
    }

    public Map<String, Object> getMember(Integer memberNo) {

        return memberMapper.findById(memberNo);
    }
}
