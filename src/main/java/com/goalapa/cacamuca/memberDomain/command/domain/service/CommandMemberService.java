package com.goalapa.cacamuca.memberDomain.command.domain.service;


import com.goalapa.cacamuca.memberDomain.command.application.dto.MemberDTO;

public interface CommandMemberService {

    void registMember(MemberDTO member);
}
