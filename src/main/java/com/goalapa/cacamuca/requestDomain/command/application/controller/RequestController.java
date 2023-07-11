package com.goalapa.cacamuca.requestDomain.command.application.controller;

import com.goalapa.cacamuca.requestDomain.command.application.dto.RequestDTO;
import com.goalapa.cacamuca.requestDomain.command.application.service.SaveRequestServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/*")
public class RequestController {

    private final SaveRequestServiceImpl saveRequestServiceImpl;

    public RequestController(SaveRequestServiceImpl saveRequestServiceImpl) {
        this.saveRequestServiceImpl = saveRequestServiceImpl;
    }

    // 요청 입력 받아서 저장
    @GetMapping("/request")
    public String requestPage() {
        return "request";
    }

    @PostMapping("/request")
    public void saveRequest(HttpServletRequest request) {
        RequestDTO requestDTO = new RequestDTO();

        String country = request.getParameter("country");
        String foodType = request.getParameter("food_type");
        String requestedFood = request.getParameter("requested_food");
        int requestPrice = Integer.parseInt(request.getParameter("request_price"));
        int memberNo = Integer.parseInt(request.getParameter("member_no")); //로그인 완료 후 수정

        requestDTO.setCountry(country);
        requestDTO.setFoodType(foodType);
        requestDTO.setRequestedFood(requestedFood);
        requestDTO.setRequestPrice(requestPrice);
        requestDTO.setMemberNo(memberNo);

        saveRequestServiceImpl.addNewRequest(requestDTO);
    }

}
