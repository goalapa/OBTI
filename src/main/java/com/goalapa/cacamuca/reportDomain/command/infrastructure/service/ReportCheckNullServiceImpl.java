package com.goalapa.cacamuca.reportDomain.command.infrastructure.service;

import com.goalapa.cacamuca.memberDomain.command.domain.aggregate.entity.Member;
import com.goalapa.cacamuca.memberDomain.command.domain.repository.MemberRepository;
import com.goalapa.cacamuca.reportDomain.command.application.dto.ReportDTO;
import com.goalapa.cacamuca.reportDomain.command.domain.service.ReportCheckNullService;
import com.goalapa.cacamuca.reviewDomain.command.domain.aggregate.entity.Review;
import com.goalapa.cacamuca.reviewDomain.command.domain.repository.ReviewRepository;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;


@Service
public class ReportCheckNullServiceImpl implements ReportCheckNullService {

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;

    public ReportCheckNullServiceImpl(ReviewRepository reviewRepository, MemberRepository memberRepository) {
        this.reviewRepository = reviewRepository;
        this.memberRepository = memberRepository;
    }

    // 신고자, 피신고자, 리뷰가 null이 아닌지 확인하는 로직 추가
    @Override
    public boolean checkNotNull(ReportDTO reportDTO)  {
        try {

            Member reportedMember = memberRepository.findById(reportDTO.getReportedMemberNo())
                    .orElseThrow(() -> new NotFoundException("존재하지않는 회원입니다."));
            Member reportMember = memberRepository.findById(reportDTO.getReportMemberNo())
                    .orElseThrow(() -> new NotFoundException("존재하지않는 회원입니다."));
            Review review = reviewRepository.findById(reportDTO.getReviewNo())
                    .orElseThrow(() -> new NotFoundException("존재하지않는 리뷰입니다."));

            return true;
        }
        catch (NotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}