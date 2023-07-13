package com.goalapa.cacamuca.memberDomain.command.application.service;

import com.goalapa.cacamuca.memberDomain.command.application.dto.MemberDTO;
import com.goalapa.cacamuca.memberDomain.command.domain.aggregate.entity.Member;
import com.goalapa.cacamuca.memberDomain.command.domain.aggregate.vo.BirthDay;
import com.goalapa.cacamuca.memberDomain.command.domain.repository.MemberRepository;
import com.goalapa.cacamuca.memberDomain.command.domain.service.CommandMemberService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements CommandMemberService {

    private final ModelMapper modelMapper;
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void registMember(MemberDTO memberDTO) {

        memberDTO.setMemberPwd(passwordEncoder.encode(memberDTO.getMemberPwd()));

        Member member =  modelMapper.map(memberDTO, Member.class);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(memberDTO.getMemberBirth(), formatter);

        BirthDay birthDay = new BirthDay(date);
        member.setBirthDay(birthDay);

        memberRepository.save(member);
    }
}
