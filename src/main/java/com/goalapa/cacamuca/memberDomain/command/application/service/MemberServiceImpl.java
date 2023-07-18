package com.goalapa.cacamuca.memberDomain.command.application.service;

import com.goalapa.cacamuca.memberDomain.command.application.dto.MemberDTO;
import com.goalapa.cacamuca.memberDomain.command.domain.aggregate.entity.Member;
import com.goalapa.cacamuca.memberDomain.command.domain.aggregate.vo.BirthDay;
import com.goalapa.cacamuca.memberDomain.command.domain.aggregate.vo.Password;
import com.goalapa.cacamuca.memberDomain.command.domain.repository.MemberRepository;
import com.goalapa.cacamuca.memberDomain.command.domain.service.CommandMemberService;
import com.goalapa.cacamuca.memberDomain.command.ininfrastructure.service.InfraCommandMemberService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements CommandMemberService {

    private final ModelMapper modelMapper;
    private final InfraCommandMemberService infraCommandMemberService;
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
        member.setMemberGrant("member");

        memberRepository.save(member);
    }

    @Transactional(rollbackOn = { RuntimeException.class, Exception.class})
    public String changeTempPassword(String id) throws Exception {
        Optional<Member> optionalMember = memberRepository.findByMemberId(id);

        if(optionalMember.isPresent()) {
            Password password = new Password();
            String originPassword = password.generateTemporalPassword();
            Member member = optionalMember.get();
            member.setMemberPwd(passwordEncoder.encode(originPassword));
            return originPassword;
        } else {
            throw new Exception("password is null");
        }
    }
}
