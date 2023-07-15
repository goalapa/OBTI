package com.goalapa.cacamuca.memberDomain.query.application.controller;

import com.goalapa.cacamuca.memberDomain.command.application.dto.CustomUser;
import com.goalapa.cacamuca.memberDomain.query.application.service.QueryMemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class QueryMemberController {

    private final QueryMemberServiceImpl memberService;

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

    @GetMapping("id/{memberId}")
    @ResponseBody
    public ResponseEntity checkIsDuplicatedId(@PathVariable String memberId) {

        Boolean result =  memberService.checkIsDuplicatedId(memberId);

        return ResponseEntity.ok(result);
    }

    @GetMapping("email/{email}")
    @ResponseBody
    public ResponseEntity checkDuplicatedEmail(@PathVariable String email) {

        Boolean result = memberService.checkIsDuplicatedEmail(email);

        return ResponseEntity.ok(result);
    }
}
