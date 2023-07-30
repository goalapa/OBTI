package com.goalapa.cacamuca.requestDomain.command.application.controller;

import com.goalapa.cacamuca.memberDomain.command.application.dto.CustomUser;
import com.goalapa.cacamuca.requestDomain.command.application.dto.RequestDTO;
import com.goalapa.cacamuca.requestDomain.command.application.service.DeleteRequestImpl;
import com.goalapa.cacamuca.requestDomain.command.application.service.DeleteRequestPicImpl;
import com.goalapa.cacamuca.requestDomain.command.application.service.SaveRequestImpl;
import com.goalapa.cacamuca.requestDomain.command.application.service.SaveRequestPicImpl;
import com.goalapa.cacamuca.requestDomain.command.domain.aggregate.entity.Request;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
//@RequestMapping("/*")
public class RequestController {
    private final SaveRequestImpl saveRequestImpl;
    private final SaveRequestPicImpl saveRequestPicImpl;
    private final DeleteRequestImpl deleteRequestImpl;
    private final DeleteRequestPicImpl deleteRequestPicImpl;



    public RequestController(SaveRequestImpl saveRequestImpl, SaveRequestPicImpl saveRequestPicImpl, DeleteRequestImpl deleteRequestImpl, DeleteRequestPicImpl deleteRequestPicImpl) {
        this.saveRequestImpl = saveRequestImpl;
        this.saveRequestPicImpl = saveRequestPicImpl;
        this.deleteRequestImpl = deleteRequestImpl;
        this.deleteRequestPicImpl = deleteRequestPicImpl;
    }


    // 요청 입력 받아서 저장
    @GetMapping("/request")
    public String requestPage() {
        return "request";
    }

    @PostMapping("/request")
    public String saveRequest(@AuthenticationPrincipal CustomUser customUser, @ModelAttribute RequestDTO requestDTO, @RequestParam MultipartFile requestPic) {

        int saveRequest = saveRequestImpl.saveRequest(requestDTO, customUser.getMemberNo());
        saveRequestPicImpl.saveRequestPic(requestPic, saveRequest);

        return "redirect:/";

    }

    @GetMapping("/request-list/delete/{requestNo}")
    public String deleteRequest(@PathVariable("requestNo") int requestNo) {
        deleteRequestImpl.deleteRequest(requestNo);
        deleteRequestPicImpl.deleteRequestPic(requestNo);

        return "redirect:/request-list";
    }

}
