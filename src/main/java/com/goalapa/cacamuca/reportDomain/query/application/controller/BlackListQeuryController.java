//package com.goalapa.cacamuca.reportDomain.query.application.controller;
//
//import com.goalapa.cacamuca.reportDomain.query.application.dto.BlackListQueryDTO;
//import com.goalapa.cacamuca.reportDomain.query.application.service.BlackListPageServiceImpl;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.web.PageableDefault;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
//
//@Controller
//@RequestMapping("/admin-page")
//public class BlackListQeuryController {
//
//    private final BlackListPageServiceImpl blackListServiceImpl;
//
//    public BlackListQeuryController(BlackListPageServiceImpl blackListServiceImpl) {
//        this.blackListServiceImpl = blackListServiceImpl;
//    }
//
//    // 블랙리스트 페이지
//    @GetMapping("/blacklist")
//    @ResponseBody
//    public ModelAndView getBlackListPage(ModelAndView model, @PageableDefault(size = 10, sort = "blacklist_reg_date", direction = Sort.Direction.DESC) Pageable pageable) {
//        Page<BlackListQueryDTO> blackListPage = blackListServiceImpl.getBlackListPage(pageable);
//
//        model.addObject("blackListPage", blackListPage);
//        model.setViewName("blacklistAdminPage");
//
//        return model;
//    }
//}
