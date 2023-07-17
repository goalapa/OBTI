package com.goalapa.cacamuca.memberDomain.query.application.controller;

import com.goalapa.cacamuca.memberDomain.query.application.service.QueryMemberServiceImpl;
import com.goalapa.cacamuca.memberDomain.query.infrastructure.service.InfraQueryMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class QueryMemberController {

    private final QueryMemberServiceImpl memberService;
    private final InfraQueryMemberService infraMemberService;

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

    @GetMapping("find-id-page")
    public String findIdPage() {

        return "member/findId";
    }


    @GetMapping("id/{memberId}")
    @ResponseBody
    public ResponseEntity checkIsDuplicatedId(@PathVariable String memberId) {

        Boolean result =  memberService.checkIsDuplicatedId(memberId);

        return ResponseEntity.ok(result);
    }

    @GetMapping("id/find-id")
    @ResponseBody
    public ResponseEntity findId(@RequestParam String email) {

        infraMemberService.sendIdToMember(email);

        return ResponseEntity.ok(true);
    }

    @GetMapping("email/{email}")
    @ResponseBody
    public ResponseEntity checkDuplicatedEmail(@PathVariable String email) {

        Boolean result = memberService.checkIsDuplicatedEmail(email);

        return ResponseEntity.ok(result);
    }
}
