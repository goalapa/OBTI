package com.goalapa.cacamuca.requestDomain.command.application.controller;

import com.goalapa.cacamuca.requestDomain.command.application.dto.RequestDTO;
import com.goalapa.cacamuca.requestDomain.command.domain.aggregate.entity.Request;
import com.goalapa.cacamuca.requestDomain.command.infrastructure.service.RequestServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/*")
public class RequestController {

    private final RequestServiceImpl requestServiceImpl;

    public RequestController(RequestServiceImpl requestServiceImpl) {
        this.requestServiceImpl = requestServiceImpl;
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

        requestServiceImpl.addNewRequest(requestDTO);
    }

}
