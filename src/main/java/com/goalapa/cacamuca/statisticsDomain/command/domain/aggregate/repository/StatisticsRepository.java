package com.goalapa.cacamuca.statisticsDomain.command.domain.aggregate.repository;

import com.goalapa.cacamuca.statisticsDomain.command.domain.aggregate.entity.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticsRepository extends JpaRepository<Statistics, Integer> {

}