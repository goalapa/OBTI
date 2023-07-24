package com.goalapa.cacamuca.reportDomain.command.application.controller;

import com.goalapa.cacamuca.reportDomain.command.application.dto.BlackListReleaseDTO;
import com.goalapa.cacamuca.reportDomain.command.application.service.BlackListServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin-page")
public class BlackListController {

    private final BlackListServiceImpl blackListServiceImpl;

    public BlackListController(BlackListServiceImpl blackListServiceImpl) {
        this.blackListServiceImpl = blackListServiceImpl;
    }

    @PostMapping("/blacklist-release")
    public ResponseEntity<String> releaseBlackListMember(@RequestBody BlackListReleaseDTO blackListReleaseDTO) {
        blackListServiceImpl.releaseBlackList(blackListReleaseDTO);

        return new ResponseEntity<>("200", HttpStatus.OK);
    }
}
