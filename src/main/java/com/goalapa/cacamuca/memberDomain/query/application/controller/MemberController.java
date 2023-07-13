package com.goalapa.cacamuca.memberDomain.query.application.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    @GetMapping("/main")
    public String main() {

        return "main";
    }

    @GetMapping("/login")
    public String login() {

        return "member/login";
    }

    @GetMapping("registration")
    public String registration() {

        return "member/registration";
    }
}
