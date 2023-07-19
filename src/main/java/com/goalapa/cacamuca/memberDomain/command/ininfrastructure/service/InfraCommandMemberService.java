package com.goalapa.cacamuca.memberDomain.command.ininfrastructure.service;

import com.goalapa.cacamuca.memberDomain.command.domain.aggregate.entity.Member;
import com.goalapa.cacamuca.memberDomain.command.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InfraCommandMemberService {

    private final MemberRepository memberRepository;

    private final JavaMailSender javaMailSender;

    @Value("spring.mail.username")
    private String sender;

    public Boolean sendPasswordToMember(String id, String password) {

        Optional<Member> optionalMember =  memberRepository.findByMemberId(id);

        if(optionalMember.isPresent()) {
            Member member = optionalMember.get();
            String emailAddress = member.getMemberEmail();
            String subject = "[cacamuca] 비밀번호 찾기";
            String text = "임시비밀번호는 " + password + " 입니다.\n" +
                          "로그인 후 계정 비밀번호를 변경해주세요.";

            SimpleMailMessage message = new SimpleMailMessage();
            message.setSubject(subject);
            message.setText(text);
            message.setFrom(sender);
            message.setTo(emailAddress);

            javaMailSender.send(message);

            return true;
        } else {
            return false;
        }
    }

}
