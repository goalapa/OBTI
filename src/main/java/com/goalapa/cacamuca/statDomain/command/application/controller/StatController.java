package com.goalapa.cacamuca.statDomain.command.application.controller;

import com.goalapa.cacamuca.statDomain.command.application.service.StatScheduler;
import com.goalapa.cacamuca.statDomain.command.domain.aggregate.entity.Stat;
import com.goalapa.cacamuca.statDomain.query.application.dto.QueryStatDTO;
import com.goalapa.cacamuca.statDomain.query.domain.service.GetStatService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.util.List;


@Controller
public class StatController {

    private final GetStatService getStatService;
    private final StatScheduler statScheduler;
    public StatController(GetStatService getStatService, StatScheduler statScheduler) {
        this.getStatService = getStatService;
        this.statScheduler = statScheduler;
    }

    @InitBinder     //String 을 LocalDate으로
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                setValue(LocalDate.parse(text));
            }
        });
    }


    @GetMapping("/stat")
    public String showStatByDate(Model model, @RequestParam(name = "selectedDate", required = false)LocalDate selectedDate
                                            ,@RequestParam(name = "country", required = false) String country,
                                    @PageableDefault Pageable pageable) {

        if (selectedDate == null) selectedDate = LocalDate.now();

        if(country == "all" || country == "") {
            Page<Stat> stats = getStatService.findStatsByDate(selectedDate, pageable);
            model.addAttribute("statPage", stats);
            model.addAttribute("selectedDate", selectedDate);
        } else {
            Page<Stat> stats = getStatService.findStatsByDateAndCountry(selectedDate, country, pageable);
            model.addAttribute("statPage", stats);
            model.addAttribute("selectedDate", selectedDate);
            model.addAttribute("country", country);
        }

        return "stat";
    }

    @GetMapping("/stat/top10")
    public String showTopTen(Model model, @RequestParam(name = "selectedDate", required = false)LocalDate selectedDate
            ,@RequestParam(name = "country", required = false) String country) {

        if (selectedDate == null) selectedDate = LocalDate.now();
        if (country == null) country = "한국";

        List<QueryStatDTO> stats = getStatService.getStatTopTen(selectedDate, country);

        model.addAttribute("statList", stats);
        model.addAttribute("selectedDate", selectedDate);
        model.addAttribute("country", country);

        return "stat-top10";
    }

    @GetMapping("/stat/show-detail/{foodNo}")
    public String showStatDetail(Model model, @PathVariable("foodNo") int foodNo) {

        model.addAttribute("foodNo", foodNo);
        List<Integer> likeCnt = getStatService.getLikeCntByMonth(foodNo);
        List<Integer> reviewCnt = getStatService.getReviewCntByMonth(foodNo);
        List<Integer> memberAgeGroup = getStatService.getMemberAgeGroupByMonth(foodNo);

        model.addAttribute("likeCnt", likeCnt);
        model.addAttribute("reviewCnt", reviewCnt);

        return "statDetail";
    }

}
