package com.goalapa.cacamuca.memberDomain.command.application.controller;

import com.goalapa.cacamuca.memberDomain.command.application.dto.CustomUser;
import com.goalapa.cacamuca.memberDomain.command.application.dto.MemberDTO;
import com.goalapa.cacamuca.memberDomain.command.application.service.MemberServiceImpl;
import com.goalapa.cacamuca.memberDomain.command.ininfrastructure.service.InfraCommandMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.Charset;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class CommandMemberController {

    private final MemberServiceImpl memberService;
    private final InfraCommandMemberService infraCommandMemberService;

    private HttpHeaders getHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        return headers;
    }

    @PostMapping("registration")
    public String registration(@ModelAttribute MemberDTO memberDTO) {

        memberService.registMember(memberDTO);

        return "redirect:main";
    }

    @PostMapping("temp-password")
    @ResponseBody
    public ResponseEntity changeTempPassword(@RequestParam String id) {

        HttpHeaders header = getHeader();

        try {
            String password =  memberService.changeTempPassword(id);
            infraCommandMemberService.sendPasswordToMember(id, password);
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            e.printStackTrace();
            String message = e.getMessage();
            return new ResponseEntity(message, header, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/modify")
    public String modifyMemberInfo(@ModelAttribute MemberDTO member, RedirectAttributes redirectAttributes) {

        try {
            memberService.modifyMemberInfo(member);

            redirectAttributes.addFlashAttribute("result", "회원 정보 수정이 완료되었습니다.");
            return "redirect:/member/my-page";
        } catch (Exception e) {
            e.printStackTrace();

            redirectAttributes.addFlashAttribute("result", "잘못된 회원정보 입니다.");
            return "redirect:/member/my-page";
        }
    }

    @PostMapping("/password")
    public String modifyMemberPassword(@ModelAttribute MemberDTO member, RedirectAttributes redirectAttributes) {

        try {
            memberService.modifyMemberInfo(member);

            redirectAttributes.addFlashAttribute("result", "비밀번호 변경이 완료되었습니다.");
            return "redirect:/member/my-password";
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("result", "잘못된 회원정보 입니다.");
            return "redirect:/member/my-password";
        }
    }

    @PostMapping("/secession")
    public void secession(@AuthenticationPrincipal CustomUser customUser, @ModelAttribute String password, RedirectAttributes redirectAttributes
            , HttpServletRequest request, HttpServletResponse response) {
        try {
            Integer memberNo = customUser.getMemberNo();
            memberService.secession(memberNo, password);
            redirectAttributes.addFlashAttribute("result", "회원탈퇴가 완료되었습니다.");
            request.getSession().invalidate();

            Cookie cookie = new Cookie("JSESSIONID", null);
            cookie.setMaxAge(0);
            cookie.setPath("/");
            response.addCookie(cookie);
            response.sendRedirect("/");
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("result", "잘못된 회원정보 입니다.");
        }
    }
}
