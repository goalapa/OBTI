package com.goalapa.cacamuca.memberDomain.command.application.service;

import com.goalapa.cacamuca.memberDomain.command.application.dto.MemberDTO;
import com.goalapa.cacamuca.memberDomain.command.domain.aggregate.entity.Member;
import com.goalapa.cacamuca.memberDomain.command.domain.aggregate.vo.BirthDay;
import com.goalapa.cacamuca.memberDomain.command.domain.aggregate.vo.Password;
import com.goalapa.cacamuca.memberDomain.command.domain.repository.MemberRepository;
import com.goalapa.cacamuca.memberDomain.command.domain.service.CommandMemberService;
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
public class CommandMemberServiceImpl implements CommandMemberService {

    private final ModelMapper modelMapper;
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void registMember(MemberDTO memberDTO) {

        memberDTO.setMemberPwd(passwordEncoder.encode(memberDTO.getMemberPwd()));

        Member member =  modelMapper.map(memberDTO, Member.class);
        member.setMemberPwd(new Password(memberDTO.getMemberPwd()));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(memberDTO.getMemberBirth(), formatter);

        BirthDay birthDay = new BirthDay(date);
        member.setBirthDay(birthDay);
        member.setMemberGrant("ROLE_MEMBER");

        memberRepository.save(member);
    }

    @Transactional(rollbackOn = { RuntimeException.class, Exception.class})
    public String changeTempPassword(String id) throws Exception {
        Optional<Member> optionalMember = memberRepository.findByMemberId(id);

        if(optionalMember.isPresent()) {
            Member member = optionalMember.get();
            String originPassword = member.getMemberPwd().generateTemporalPassword();
            member.setMemberPwd(new Password(passwordEncoder.encode(originPassword)));
            return originPassword;
        } else {
            throw new Exception("password is null");
        }
    }

    @Transactional
    public void modifyMemberInfo(MemberDTO memberDTO) throws Exception {
        Optional<Member> optionalMember = memberRepository.findById(memberDTO.getMemberNo());

        if (optionalMember.isPresent()) {
            Member member = optionalMember.get();
            if (memberDTO.getMemberNickname() != null) member.setMemberNickname(memberDTO.getMemberNickname());
            if (memberDTO.getMemberEmail() != null) member.setMemberEmail(memberDTO.getMemberEmail());
            if (memberDTO.getMemberCountry() != null) member.setMemberCountry(memberDTO.getMemberCountry());
            if (memberDTO.getMemberBirth() != null) member.setBirthDay(new BirthDay(LocalDate.parse(memberDTO.getMemberBirth(), DateTimeFormatter.ofPattern("yyyy-MM-dd"))));
        } else {
            throw new Exception("변경할 회원정보가 없습니다.");
        }
    }

    @Transactional
    public void modifyMemberPassword(MemberDTO memberDTO) throws Exception {
        Optional<Member> optionalMember = memberRepository.findById(memberDTO.getMemberNo());

        if(optionalMember.isPresent()) {
            Member member = optionalMember.get();
            String encodedPassword =  passwordEncoder.encode(memberDTO.getMemberPwd());
            if(memberDTO.getMemberPwd() != null) member.setMemberPwd(new Password(encodedPassword));
        } else {
            throw new Exception("변경할 회원정보가 없습니다.");
        }
    }

    @Transactional
    public void secession(Integer memberNo, String password) throws Exception {

        Optional<Member> optionalMember = memberRepository.findById(memberNo);

        if(optionalMember.isPresent()) {
            Member member = optionalMember.get();

            String encodedPassword = passwordEncoder.encode(password);

            if(passwordEncoder.matches(password, encodedPassword)) {
                member.setMemberId(null);
                member.setMemberEmail(null);
                member.setMemberPwd(null);
            }
        } else {
            throw new Exception("회원정보가 없습니다.");
        }
    }
}
