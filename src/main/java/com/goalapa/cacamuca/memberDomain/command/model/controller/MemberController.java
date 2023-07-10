package com.goalapa.cacamuca.memberDomain.command.model.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class MemberController {

    @GetMapping("/memberList")
    public Map<String, Object> getMemberList() {

    }
}
