package com.goalapa.cacamuca.memberDomain.query.application.controller;

import com.goalapa.cacamuca.memberDomain.command.application.dto.CustomUser;
import com.goalapa.cacamuca.memberDomain.query.application.service.QueryMemberServiceImpl;
import com.goalapa.cacamuca.memberDomain.query.domain.aggregate.dto.MemberDTO;
import com.goalapa.cacamuca.memberDomain.query.domain.aggregate.entity.Member;
import com.goalapa.cacamuca.memberDomain.query.infrastructure.service.InfraQueryMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class QueryMemberController {

    private final QueryMemberServiceImpl memberService;
    private final InfraQueryMemberService infraMemberService;

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

    @GetMapping("find-password-page")
    public String findPasswordPage() {

        return "member/findPassword";
    }

    @GetMapping("my-page")
    public ModelAndView findMyPage(@AuthenticationPrincipal CustomUser user, ModelAndView mv) {

        String memberId =  user.getUsername();

        Member member = memberService.findId(memberId);

        mv.addObject("member", member);
        mv.setViewName("member/my-page");

        return mv;
    }

    @GetMapping("admin-list")
    public ModelAndView findAdminPage(ModelAndView mv, @PageableDefault(page = 1, size = 10) Pageable pageable) {

        Page<MemberDTO> members = memberService.findMemberList(pageable);

        mv.addObject("members", members);
        mv.setViewName("adminList");

        return mv;
    }

    @GetMapping("memberList")
    @ResponseBody
    public ResponseEntity getPage(@PageableDefault(page = 1, size = 10) Pageable pageable) {

        Page<MemberDTO> members = memberService.findMemberList(pageable);

        return ResponseEntity.ok(members);
    }

    @GetMapping("my-password")
    public ModelAndView findMyPasswordPage(@AuthenticationPrincipal CustomUser user, ModelAndView mv) {

        String memberId =  user.getUsername();

        Member member = memberService.findId(memberId);

        mv.addObject("member", member);
        mv.setViewName("member/my-password");

        return mv;
    }

    @GetMapping("secession")
    public String secessionPage() {

        return "member/secession";
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

        Boolean result =  infraMemberService.sendIdToMember(email);

        return ResponseEntity.ok(result);
    }

    @GetMapping("email/{email}")
    @ResponseBody
    public ResponseEntity checkDuplicatedEmail(@PathVariable String email) {

        Boolean result = memberService.checkIsDuplicatedEmail(email);

        return ResponseEntity.ok(result);
    }
}
