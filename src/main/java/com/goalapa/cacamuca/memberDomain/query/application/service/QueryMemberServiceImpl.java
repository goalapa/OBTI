package com.goalapa.cacamuca.memberDomain.query.application.service;

import com.goalapa.cacamuca.memberDomain.query.domain.aggregate.dto.MemberDTO;
import com.goalapa.cacamuca.memberDomain.query.domain.aggregate.entity.Member;
import com.goalapa.cacamuca.memberDomain.query.domain.repository.MemberMapper;
import com.goalapa.cacamuca.memberDomain.query.domain.service.QueryMemberService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Service
public class QueryMemberServiceImpl implements QueryMemberService {

    private final MemberMapper memberMapper;

    private final ModelMapper modelMapper;


    @Override
    public Boolean checkIsDuplicatedId(String memberId) {

        Member member = memberMapper.findByMemberId(memberId);

        if(member == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean checkIsDuplicatedEmail(String email) {

        Member member = memberMapper.findByMemberEmail(email);

        if(member == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Member findId(String memberId) {

        Member member = memberMapper.getMember(memberId);

        return member;
    }

    public Page<MemberDTO> findMemberList(Pageable pageable) {

        List<Member> memberList = memberMapper.findMembers(pageable);
        Integer count = memberMapper.countMembers();

        List<MemberDTO> members =  memberList.stream().map(member -> modelMapper.map(member, MemberDTO.class)).collect(Collectors.toList());

        Page<MemberDTO> page =  new PageImpl<>(members, pageable, count);

        return page;
    }
}
