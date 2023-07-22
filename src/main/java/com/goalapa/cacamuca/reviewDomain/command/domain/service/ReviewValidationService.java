package com.goalapa.cacamuca.reviewDomain.command.domain.service;

import com.goalapa.cacamuca.reportDomain.command.domain.aggregate.vo.ReportMemberVO;
import com.goalapa.cacamuca.reportDomain.command.domain.aggregate.vo.ReportedMemberVO;
import com.goalapa.cacamuca.reportDomain.command.domain.aggregate.vo.ReviewVO;
import com.goalapa.cacamuca.reviewDomain.command.domain.aggregate.entity.Review;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewValidationService {
    boolean checkHeartCondition(Review review, Integer no, Integer memberNo);
    boolean checkReportCondition(Review review, ReviewVO reviewVO, ReportMemberVO reportMemberVO, ReportedMemberVO reportedMemberVO);

}
