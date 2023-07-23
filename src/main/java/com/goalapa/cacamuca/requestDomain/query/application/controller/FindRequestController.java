package com.goalapa.cacamuca.requestDomain.query.application.controller;

import com.goalapa.cacamuca.requestDomain.command.domain.aggregate.entity.Request;
import com.goalapa.cacamuca.requestDomain.query.application.dto.FindRequestDTO;
import com.goalapa.cacamuca.requestDomain.query.application.dto.FindRequestPicDTO;
import com.goalapa.cacamuca.requestDomain.query.application.service.FindRequestPicService;
import com.goalapa.cacamuca.requestDomain.query.application.service.FindRequestService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/request-list")
public class FindRequestController {

    private final FindRequestService findRequestService;
    private final FindRequestPicService findRequestPicService;

    public FindRequestController(FindRequestService findRequestService, FindRequestPicService findRequestPicService) {
        this.findRequestService = findRequestService;
        this.findRequestPicService = findRequestPicService;
    }


    @GetMapping("")
    public String adminRequestPage(Model model, @PageableDefault(size = 5) Pageable pageable) {
        Page<Request> requestPage = findRequestService.findAllRequest(pageable);

        model.addAttribute("requestPage", requestPage);

        return "request-list";
    }

    @GetMapping("/view/{requestNo}")
    public String requestViewDetailPage(@PathVariable("requestNo") int requestNo, Model model) {

        FindRequestDTO request = findRequestService.findRequestByRequestNo(requestNo);
        FindRequestPicDTO requestPic = findRequestPicService.findRequestPicByRequestNo(requestNo);

        model.addAttribute("selectRequest", request);
        model.addAttribute("selectRequestPic", requestPic);

        return "request-detail";
    }


}
