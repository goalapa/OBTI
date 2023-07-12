package com.goalapa.cacamuca.memberDomain.query.application.service;

import com.goalapa.cacamuca.memberDomain.command.domain.repository.MemberRepository;
import com.goalapa.cacamuca.memberDomain.query.domain.repository.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;

    public Map<String, Object> getMember(Integer memberNo) {

        return memberMapper.findById(memberNo);
    }
}
