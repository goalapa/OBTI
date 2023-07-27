package com.goalapa.cacamuca.statDomain.query.domain.respository;

import com.goalapa.cacamuca.statDomain.command.domain.aggregate.entity.Stat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface QueryStatRepository extends JpaRepository<Stat, Integer> {

    Page<Stat> findByUpdateDate(LocalDate date, Pageable pageable);

    Page<Stat> findByUpdateDateAndCountry(LocalDate date, String country, Pageable pageable);
}
