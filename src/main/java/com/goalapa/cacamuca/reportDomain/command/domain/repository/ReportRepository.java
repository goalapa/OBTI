package com.goalapa.cacamuca.reportDomain.command.domain.repository;

import com.goalapa.cacamuca.reportDomain.command.domain.aggregate.entity.Report;
import com.goalapa.cacamuca.reportDomain.command.domain.aggregate.vo.ReportMemberVO;
import com.goalapa.cacamuca.reportDomain.command.domain.aggregate.vo.ReportedMemberVO;
import com.goalapa.cacamuca.reportDomain.command.domain.aggregate.vo.ReviewVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;


@Repository
public interface ReportRepository extends JpaRepository<Report, Integer>{
    List<Report> findByReviewVO(ReviewVO reviewVO);
    Optional<Object> findByReviewVOAndReportMemberVO(ReviewVO reviewVO, ReportMemberVO reportMemberVO);
    Optional<Object> findByReportedMemberVOAndReportMemberVO(ReportedMemberVO reportedMemberVO, ReportMemberVO reportMemberVO);
}
