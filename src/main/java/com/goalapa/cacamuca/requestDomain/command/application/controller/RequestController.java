package com.goalapa.cacamuca.requestDomain.command.application.controller;

import com.goalapa.cacamuca.requestDomain.command.application.dto.RequestDTO;
import com.goalapa.cacamuca.requestDomain.command.application.service.SaveRequestServiceImpl;
import com.goalapa.cacamuca.requestDomain.command.infrastructure.service.CheckRequestServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/*")
public class RequestController {

    private final CheckRequestServiceImpl checkRequestServiceImpl;



    public RequestController(CheckRequestServiceImpl checkRequestServiceImpl) {
        this.checkRequestServiceImpl = checkRequestServiceImpl;
    }


    // 요청 입력 받아서 저장
    @GetMapping("/request")
    public String requestPage() {
        return "request";
    }

    @PostMapping("/request")
    public void saveRequest(@ModelAttribute RequestDTO requestDTO) {
        System.out.println("requestDTO = " + requestDTO.toString());
        checkRequestServiceImpl.checkNotNull(requestDTO);
    }

}
