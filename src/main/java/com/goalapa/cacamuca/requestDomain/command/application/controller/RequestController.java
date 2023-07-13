package com.goalapa.cacamuca.requestDomain.command.application.controller;

import com.goalapa.cacamuca.requestDomain.command.application.dto.RequestDTO;
import com.goalapa.cacamuca.requestDomain.command.application.service.SaveRequestPicServiceImpl;
import com.goalapa.cacamuca.requestDomain.command.infrastructure.service.CheckRequestServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/*")
public class RequestController {

    private final CheckRequestServiceImpl checkRequestServiceImpl;
    private final SaveRequestPicServiceImpl saveRequestPicServiceImpl;



    public RequestController(CheckRequestServiceImpl checkRequestServiceImpl, SaveRequestPicServiceImpl saveRequestPicServiceImpl) {
        this.checkRequestServiceImpl = checkRequestServiceImpl;
        this.saveRequestPicServiceImpl = saveRequestPicServiceImpl;
    }


    // 요청 입력 받아서 저장
    @GetMapping("/request")
    public String requestPage() {
        return "request";
    }

    @PostMapping(value = "/request")
    public void saveRequest(@ModelAttribute RequestDTO requestDTO, @RequestParam MultipartFile requestPic) {

        checkRequestServiceImpl.checkNotNull(requestDTO);
        saveRequestPicServiceImpl.saveRequestPic(requestPic);

    }

}
