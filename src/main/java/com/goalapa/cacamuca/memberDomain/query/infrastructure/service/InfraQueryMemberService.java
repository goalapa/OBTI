package com.goalapa.cacamuca.memberDomain.query.infrastructure.service;

import com.goalapa.cacamuca.memberDomain.query.domain.aggregate.entity.Member;
import com.goalapa.cacamuca.memberDomain.query.domain.repository.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InfraQueryMemberService {

    private final MemberMapper memberMapper;

    private final JavaMailSender javaMailSender;

    @Value("spring.mail.username")
    private String sender;

    public Boolean sendIdToMember(String emailAddress) {

        Member member =  memberMapper.findByMemberEmail(emailAddress);

        if(member != null) {
            String subject = "[cacamuca] 아이디 찾기";
            String text = "아이디는" + member.getMemberId() + " 입니다.";

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

    public Boolean sendPasswordToMember(String id) {

        Member member =  memberMapper.findByMemberId(id);

        if(member != null) {
            String emailAddress = member.getMemberEmail();
            String subject = "[cacamuca] 비밀번호 찾기";
            String text = "비밀번호는" + "" + " 입니다.";

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
