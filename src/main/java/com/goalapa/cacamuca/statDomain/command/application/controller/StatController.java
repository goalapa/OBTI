package com.goalapa.cacamuca.statDomain.command.application.controller;

import com.goalapa.cacamuca.statDomain.command.application.service.StatScheduler;
import com.goalapa.cacamuca.statDomain.query.application.dto.QueryStatDTO;
import com.goalapa.cacamuca.statDomain.query.domain.service.GetStatService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class StatController {

    private final GetStatService getStatService;
    private final StatScheduler statScheduler;
    public StatController(GetStatService getStatService, StatScheduler statScheduler) {
        this.getStatService = getStatService;
        this.statScheduler = statScheduler;
    }

    @GetMapping("/stat")
    public String requestPage(Model model) {

        statScheduler.insertData();

        List<QueryStatDTO> stats = getStatService.findAllStats();

        model.addAttribute("statList", stats);

        return "stat";
    }

}
