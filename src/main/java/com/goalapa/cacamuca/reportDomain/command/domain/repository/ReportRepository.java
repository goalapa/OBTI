package com.goalapa.cacamuca.reportDomain.command.domain.repository;

import com.goalapa.cacamuca.reportDomain.command.domain.aggregate.entity.Report;
import com.goalapa.cacamuca.reportDomain.command.domain.aggregate.vo.ReviewVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report, Integer>{

    List<Report> findByReviewVO(ReviewVO reviewVO);
}
