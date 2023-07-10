package com.goalapa.cacamuca.memberDomain.command.model.controller;

import com.goalapa.cacamuca.memberDomain.command.domain.aggregate.entity.Member;
import com.goalapa.cacamuca.memberDomain.command.model.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/memberList")
    @ResponseBody
    public List<Member> getMemberList() {

        return memberService.getMemberList();
    }

    @GetMapping("/member")
    @ResponseBody
    public Map<String, Object> getMember() {

        Integer memberNo = 1;

        return memberService.getMember(memberNo);
    }
}
