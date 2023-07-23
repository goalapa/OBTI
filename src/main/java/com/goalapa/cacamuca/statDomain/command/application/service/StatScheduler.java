package com.goalapa.cacamuca.statDomain.command.application.service;

import com.goalapa.cacamuca.statDomain.command.application.dto.StatDTO;
import com.goalapa.cacamuca.statDomain.command.domain.aggregate.service.SaveStatService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class StatScheduler {

    private final SaveStatService saveStatService;

    public StatScheduler(SaveStatService saveStatService) {
        this.saveStatService = saveStatService;
    }

    @Scheduled(cron = "0 0 3 * * *")
    public void insertData() {

        //DTO set


        StatDTO statDTO = new StatDTO();
        saveStatService.insertData(statDTO);

    }
}
