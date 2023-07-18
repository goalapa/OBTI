package com.goalapa.cacamuca.memberDomain.command.application.controller;

import com.goalapa.cacamuca.memberDomain.command.application.dto.MemberDTO;
import com.goalapa.cacamuca.memberDomain.command.application.service.MemberServiceImpl;
import com.goalapa.cacamuca.memberDomain.command.ininfrastructure.service.InfraCommandMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/")
    public void modifyMemberInfo(@ModelAttribute MemberDTO member) {

        memberService.modifyMemberInfo(member);
    }
}
