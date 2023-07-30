package com.goalapa.cacamuca.reportDomain.command.application.service;

import com.goalapa.cacamuca.memberDomain.command.domain.aggregate.entity.Member;
import com.goalapa.cacamuca.memberDomain.command.domain.repository.MemberRepository;
import com.goalapa.cacamuca.reportDomain.command.application.dto.ReportCreateDTO;
import com.goalapa.cacamuca.reportDomain.command.application.dto.ReportDeleteDTO;
import com.goalapa.cacamuca.reportDomain.command.domain.aggregate.entity.Report;
import com.goalapa.cacamuca.reportDomain.command.domain.aggregate.vo.ReviewVO;
import com.goalapa.cacamuca.reportDomain.command.domain.repository.BlackListRepository;
import com.goalapa.cacamuca.reportDomain.command.domain.repository.ReportRepository;
import com.goalapa.cacamuca.reviewDomain.command.domain.aggregate.entity.Review;
import com.goalapa.cacamuca.reviewDomain.command.domain.repository.ReviewRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@Transactional
public class ReportServiceTests {

    @Autowired
    ReportServiceImpl reportService;

    @Autowired
    ReportRepository reportRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    BlackListRepository blackListRepository;

    @Autowired
    ReviewRepository reviewRepository;


    @Test
    @DisplayName("신고 생성 기능")
    public void reportCreateTest() {

        // given
        ReportCreateDTO reportCreateDTO = new ReportCreateDTO();
        reportCreateDTO.setReviewNo(1);
        reportCreateDTO.setReportType(3);
        reportCreateDTO.setReportedMemberNo(2);

        long repositoryCnt = reportRepository.count();

        // when
        reportService.saveNewReport(reportCreateDTO, "abc000");

        // then
        Assertions.assertEquals(repositoryCnt + 1, reportRepository.count());
    }

    @Test
    @DisplayName("신고 삭제 기능")
    public void reportDeleteTest() {

        // given
        ReportCreateDTO reportCreateDTO = new ReportCreateDTO();
        reportCreateDTO.setReviewNo(1);
        reportCreateDTO.setReportType(3);
        reportCreateDTO.setReportedMemberNo(2);

        reportService.saveNewReport(reportCreateDTO, "abc000");

        long repositoryCnt = reportRepository.count();

        List<Report> list = reportRepository.findAll();

        // when
        reportService.deleteReportById(list.get(list.size() - 1).getReportNo());

        // then
        Assertions.assertEquals(repositoryCnt - 1, reportRepository.count());
    }

    // 신고횟수 + 1
    @Test
    @DisplayName("누적 신고 횟수 추가 : 신고 완료")
    public void reportCntTest() {

        // given
        ReportDeleteDTO reportDeleteDTO = new ReportDeleteDTO();
        reportDeleteDTO.setReportNo(1);
        reportDeleteDTO.setReportedMemberNo(3);
        reportDeleteDTO.setReviewNo(1);
        reportDeleteDTO.setIsAccept("true");

        Optional<Member> member = memberRepository.findById(reportDeleteDTO.getReportedMemberNo());

        int reportCnt = member.get().getMemberReportCnt();

        // when
        int result = reportService.addReportCount(reportDeleteDTO);

        // then
        Assertions.assertEquals(reportCnt + 1, result);
    }

    // 블랙 리스트 저장
    @Test
    @DisplayName("블랙리스트 저장")
    public void blacklistSaveTest() {

        // given
        int reportedMemberNo = 10;
        long blacklistCnt = blackListRepository.count();

        Optional<Member> member = memberRepository.findById(reportedMemberNo);

        //when
        reportService.saveBlackList(reportedMemberNo);

        // then
        long resultCnt = blackListRepository.count();
        boolean resultBlacklistType = member.get().getBlackListType();

        Assertions.assertEquals(blacklistCnt + 1, resultCnt);
        Assertions.assertTrue(resultBlacklistType);
    }

    // 리뷰에 신고 횟수 추가 & 신고 많이 당한 리뷰는 삭제
    @Test
    @DisplayName("신고 많이 당한 리뷰 & 관련된 신고 삭제")
    public void reportDeleteReviewWithReportedCnt() {

        // given
        ReportDeleteDTO reportDeleteDTO = new ReportDeleteDTO();
        reportDeleteDTO.setReportNo(1);
        reportDeleteDTO.setReportedMemberNo(3);
        reportDeleteDTO.setReviewNo(1);
        reportDeleteDTO.setIsAccept("true");

        Optional<Review> review = reviewRepository.findById(reportDeleteDTO.getReviewNo());
        review.get().setReportCnt(10);

        // when
        reportService.deleteReviewWithReportedCnt(reportDeleteDTO);

        // then
        Optional<Review> resultOptional = reviewRepository.findById(reportDeleteDTO.getReviewNo());
        long resultSize = reportRepository.findByReviewVO(new ReviewVO(review.get().getReviewNo())).size();

        Assertions.assertEquals(Optional.empty(), resultOptional);
        Assertions.assertEquals(0, resultSize);
    }

    // 리뷰에 신고 횟수 추가 & 신고 많이 당한 리뷰는 삭제
    @Test
    @DisplayName("리뷰에 신고 횟수 추가")
    public void reportIncreaseReportCntWithReviewNo() {

        // given
        List<Report> reportList = reportRepository.findAll();
        int reportNo = reportList.get(reportList.size() - 1).getReportNo();

        ReportDeleteDTO reportDeleteDTO = new ReportDeleteDTO();
        reportDeleteDTO.setReportNo(reportNo);
        reportDeleteDTO.setReportedMemberNo(3);
        reportDeleteDTO.setReviewNo(1);
        reportDeleteDTO.setIsAccept("true");

        Optional<Review> review = reviewRepository.findById(reportDeleteDTO.getReviewNo());
        review.get().setReportCnt(8);
        long reviewReportedCnt = review.get().getReportCnt();

        // when
        reportService.deleteReviewWithReportedCnt(reportDeleteDTO);

        // then
        Optional<Review> resultReview = reviewRepository.findById(reportDeleteDTO.getReviewNo());
        long resultCnt = resultReview.get().getReportCnt();

        Assertions.assertEquals(reviewReportedCnt + 1, resultCnt);
    }
}
