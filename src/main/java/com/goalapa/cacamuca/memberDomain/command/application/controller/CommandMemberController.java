package com.goalapa.cacamuca.memberDomain.command.application.controller;

import com.goalapa.cacamuca.memberDomain.command.application.dto.MemberDTO;
import com.goalapa.cacamuca.memberDomain.command.application.service.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class CommandMemberController {

    private final MemberServiceImpl memberService;

    @PostMapping("registration")
    public String registration(@ModelAttribute MemberDTO memberDTO) {

        memberService.registMember(memberDTO);

        return "redirect:main";
    }

}
