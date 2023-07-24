package com.goalapa.cacamuca.statDomain.command.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class StatController {

    @GetMapping("/stat")
    public String requestPage(Model model) {



        return "stat";
    }

}
