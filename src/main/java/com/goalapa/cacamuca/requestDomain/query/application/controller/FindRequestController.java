package com.goalapa.cacamuca.requestDomain.query.application.controller;

import com.goalapa.cacamuca.requestDomain.query.application.dto.FindRequestDTO;
import com.goalapa.cacamuca.requestDomain.query.application.dto.FindRequestPicDTO;
import com.goalapa.cacamuca.requestDomain.query.application.service.FindRequestPicService;
import com.goalapa.cacamuca.requestDomain.query.application.service.FindRequestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/adminRequest")
public class FindRequestController {

    private final FindRequestService findRequestService;
    private final FindRequestPicService findRequestPicService;


    public FindRequestController(FindRequestService findRequestService, FindRequestPicService findRequestPicService) {
        this.findRequestService = findRequestService;
        this.findRequestPicService = findRequestPicService;
    }


    @GetMapping("")
    public String adminRequestPage(Model model) {
        List<FindRequestDTO> requests = findRequestService.findAllRequestService();

        model.addAttribute("requestList", requests);

        return "adminRequest";
    }

    @GetMapping("/view/{requestNo}")
//    public String requestViewDetailPage(@PathVariable("requestNo") int requestNo, Model model) {
    public String requestViewDetailPage(@PathVariable("requestNo") int requestNo, Model model) {

        FindRequestDTO request = findRequestService.findRequestByRequestNo(requestNo);
        FindRequestPicDTO requestPic = findRequestPicService.findRequestPicByRequestNo(requestNo);

        model.addAttribute("selectRequest", request);
        model.addAttribute("selectRequestPic", requestPic);

        return "viewRequestDetail";
    }


    @PostMapping(value = "/view/saveRequest")
    public String saveRequest(@ModelAttribute FindRequestDTO findRequestDTO) {

//        saveRequestToFoodImpl.saveRequestToFood(findRequestDTO);

        return "redirect:/adminRequest";
    }
}
