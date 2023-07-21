package com.goalapa.cacamuca.requestDomain.command.application.controller;

import com.goalapa.cacamuca.requestDomain.command.application.dto.RequestDTO;
import com.goalapa.cacamuca.requestDomain.command.application.service.DeleteRequestImpl;
import com.goalapa.cacamuca.requestDomain.command.application.service.DeleteRequestPicImpl;
import com.goalapa.cacamuca.requestDomain.command.application.service.SaveRequestPicImpl;
import com.goalapa.cacamuca.requestDomain.command.infrastructure.service.CheckRequestServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping("/*")
public class RequestController {

    private final CheckRequestServiceImpl checkRequestImpl;
    private final SaveRequestPicImpl saveRequestPicImpl;
    private final DeleteRequestImpl deleteRequestImpl;
    private final DeleteRequestPicImpl deleteRequestPicImpl;



    public RequestController(CheckRequestServiceImpl checkRequestImpl, SaveRequestPicImpl saveRequestPicImpl, DeleteRequestImpl deleteRequestImpl, DeleteRequestPicImpl deleteRequestPicImpl) {
        this.checkRequestImpl = checkRequestImpl;
        this.saveRequestPicImpl = saveRequestPicImpl;
        this.deleteRequestImpl = deleteRequestImpl;
        this.deleteRequestPicImpl = deleteRequestPicImpl;
    }


    // 요청 입력 받아서 저장
    @GetMapping("/request")
    public String requestPage() {
        return "request";
    }

//    @PostMapping("/request")
    @PostMapping("/request")
    public String saveRequest(@ModelAttribute RequestDTO requestDTO, @RequestParam MultipartFile requestPic) {

        checkRequestImpl.checkNotNull(requestDTO);
        saveRequestPicImpl.saveRequestPic(requestPic);



        return "redirect:/";

    }

    @GetMapping("/request-list/delete/{requestNo}")
    public String deleteRequest(@PathVariable("requestNo") int requestNo) {
        deleteRequestImpl.deleteRequest(requestNo);
        deleteRequestPicImpl.deleteRequestPic(requestNo);

        return "redirect:/request-list";
    }

}
