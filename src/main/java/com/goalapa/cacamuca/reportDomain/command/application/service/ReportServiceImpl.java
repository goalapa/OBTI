package com.goalapa.cacamuca.reportDomain.command.application.service;

import com.goalapa.cacamuca.memberDomain.command.domain.aggregate.entity.Member;
import com.goalapa.cacamuca.memberDomain.command.domain.repository.MemberRepository;
import com.goalapa.cacamuca.reportDomain.command.application.dto.ReportCreateDTO;
import com.goalapa.cacamuca.reportDomain.command.application.dto.ReportDeleteDTO;
import com.goalapa.cacamuca.reportDomain.command.domain.aggregate.entity.BlackList;
import com.goalapa.cacamuca.reportDomain.command.domain.aggregate.entity.Report;
import com.goalapa.cacamuca.reportDomain.command.domain.aggregate.vo.BlackListMemberVO;
import com.goalapa.cacamuca.reportDomain.command.domain.aggregate.vo.ReportMemberVO;
import com.goalapa.cacamuca.reportDomain.command.domain.aggregate.vo.ReportedMemberVO;
import com.goalapa.cacamuca.reportDomain.command.domain.aggregate.vo.ReviewVO;
import com.goalapa.cacamuca.reportDomain.command.domain.repository.BlackListRepository;
import com.goalapa.cacamuca.reportDomain.command.domain.repository.ReportRepository;
import com.goalapa.cacamuca.reportDomain.command.domain.service.ReportService;
import com.goalapa.cacamuca.reviewDomain.command.domain.aggregate.entity.Review;
import com.goalapa.cacamuca.reviewDomain.command.domain.repository.ReviewRepository;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ReportServiceImpl implements ReportService {
    private final ReportRepository reportRepository;
    private final MemberRepository memberRepository;
    private final BlackListRepository blackListRepository;
    private final ReviewRepository reviewRepository;

    public ReportServiceImpl(ReportRepository reportRepository, MemberRepository memberRepository, BlackListRepository blackListRepository, ReviewRepository reviewRepository) {
        this.reportRepository = reportRepository;
        this.memberRepository = memberRepository;
        this.blackListRepository = blackListRepository;
        this.reviewRepository = reviewRepository;
    }

    // 신고 저장
    @Override
    @Transactional
    public void saveNewReport(ReportCreateDTO reportCreateDTO, String reportMemberId) {

        Optional<Member> reportMember = memberRepository.findByMemberId(reportMemberId);
        Integer reportMemberNo = reportMember.orElseGet(() -> new Member()).getMemberNo();

        ReviewVO reviewVO = new ReviewVO(reportCreateDTO.getReviewNo());
        ReportMemberVO reportMemberVO = new ReportMemberVO(reportMemberNo);
        ReportedMemberVO reportedMemberVO = new ReportedMemberVO(reportCreateDTO.getReportedMemberNo());

        Report report = new Report(reviewVO, reportMemberVO, reportedMemberVO, reportCreateDTO.getReportType());

        reportRepository.save(report);
    }

    // 신고 삭제
    @Override
    @Transactional
    public void deleteReportById(int reportNo) {

        try {

            Report report = reportRepository.findById(reportNo)
                    .orElseThrow(() -> new NotFoundException("존재하지않는 신고입니다."));
            reportRepository.delete(report);

        }
        catch (NotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    // 피신고자의 누적 신고 횟수 + 1
    @Override
    @Transactional
    public int addReportCount(ReportDeleteDTO reportDeleteDTO) {

        try {

            Member member = memberRepository.findById(reportDeleteDTO.getReportedMemberNo())
                    .orElseThrow(() -> new NotFoundException("존재하지않는 회원입니다."));

            int reportCnt = member.getMemberReportCnt() + 1;
            member.setMemberReportCnt(reportCnt);

            return reportCnt;

        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    // 블랙 리스트 저장
    @Override
    @Transactional
    public void saveBlackList(Integer reportedMemberNo) {

        try {

            Member member = memberRepository.findById(reportedMemberNo)
                    .orElseThrow(() -> new NotFoundException("존재하지않는 회원입니다."));

            if (!member.getBlackListType()){
                member.setBlackListType(true);
                BlackListMemberVO blackListMemberVO = new BlackListMemberVO(member.getMemberNo());
                BlackList blacklist = new BlackList(blackListMemberVO, LocalDate.now(), null);
                blackListRepository.save(blacklist);
            }

        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    // 리뷰에 신고 횟수 추가 & 신고 많이 당한 리뷰는 삭제
    @Override
    @Transactional
    public void deleteReviewWithReportedCnt(ReportDeleteDTO reportDeleteDTO) {

        try {
            Review reportedReview = reviewRepository.findById(reportDeleteDTO.getReviewNo())
                    .orElseThrow(() -> new NotFoundException("존재하지않는 리뷰입니다."));

            int reviewReportCnt = 0;
            if (reportedReview.getReportCnt() != null) {
                reviewReportCnt = reportedReview.getReportCnt();
            }

            // 리뷰의 누적 신고 횟수가 10 이상일 떄
            if (reviewReportCnt >= 10) {
                // 해당 리뷰와 관련된 다른 신고들도 전부 삭제
                ReviewVO reviewVO = new ReviewVO(reportDeleteDTO.getReviewNo());
                List<Report> reports = reportRepository.findByReviewVO(reviewVO);
                reportRepository.deleteAll(reports);

                // 리뷰 삭제
                reviewRepository.delete(reportedReview);
            }
            else {
                reportedReview.setReportCnt(reviewReportCnt + 1);
            }

        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
