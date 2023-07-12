package com.goalapa.cacamuca.memberDomain.query.application.controller;

import com.goalapa.cacamuca.memberDomain.command.domain.aggregate.entity.Member;
import com.goalapa.cacamuca.memberDomain.query.application.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/main")
    public String main() {

        return "/main";
    }

    @GetMapping("/member")
    @ResponseBody
    public Map<String, Object> getMember() {

        Integer memberNo = 1;

        return memberService.getMember(memberNo);
    }
}
