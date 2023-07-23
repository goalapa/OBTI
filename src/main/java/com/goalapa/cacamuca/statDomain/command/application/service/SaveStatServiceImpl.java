package com.goalapa.cacamuca.statDomain.command.application.service;

import com.goalapa.cacamuca.statDomain.command.application.dto.StatDTO;
import com.goalapa.cacamuca.statDomain.command.domain.aggregate.entity.Stat;
import com.goalapa.cacamuca.statDomain.command.domain.aggregate.repository.StatRepository;
import com.goalapa.cacamuca.statDomain.command.domain.aggregate.service.SaveStatService;
import org.springframework.stereotype.Service;

@Service
public class SaveStatServiceImpl implements SaveStatService {

    private final StatRepository statRepository;

    public SaveStatServiceImpl(StatRepository statRepository) {
        this.statRepository = statRepository;
    }

    @Override
    public void insertData(StatDTO statDTO) {
        Stat stat = new Stat();

        statRepository.save(stat);
    }
}
