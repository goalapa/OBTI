package com.goalapa.cacamuca.reportDomain.command.application.service;

import com.goalapa.cacamuca.memberDomain.command.domain.aggregate.entity.Member;
import com.goalapa.cacamuca.memberDomain.command.domain.repository.MemberRepository;
import com.goalapa.cacamuca.reportDomain.command.application.dto.ReportDTO;
import com.goalapa.cacamuca.reportDomain.command.domain.aggregate.entity.Report;
import com.goalapa.cacamuca.reportDomain.command.domain.aggregate.vo.ReportMemberVO;
import com.goalapa.cacamuca.reportDomain.command.domain.aggregate.vo.ReportedMemberVO;
import com.goalapa.cacamuca.reportDomain.command.domain.aggregate.vo.ReviewVO;
import com.goalapa.cacamuca.reportDomain.command.domain.repository.ReportRepository;
import com.goalapa.cacamuca.reportDomain.command.domain.service.ReportService;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ReportServiceImpl implements ReportService {
    private final ReportRepository reportRepository;
    private final MemberRepository memberRepository;

    public ReportServiceImpl(ReportRepository reportRepository, MemberRepository memberRepository) {
        this.reportRepository = reportRepository;
        this.memberRepository = memberRepository;
    }

    // 신고 저장
    @Override
    @Transactional
    public void saveNewReport(ReportDTO reportDTO) {
        ReviewVO reviewVO = new ReviewVO(reportDTO.getReviewNo());
        ReportMemberVO reportMemberVO = new ReportMemberVO(reportDTO.getReportMemberNo());
        ReportedMemberVO reportedMemberVO = new ReportedMemberVO(reportDTO.getReportedMemberNo());

        Report report = new Report(reviewVO, reportMemberVO, reportedMemberVO, reportDTO.getReportType());

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
    public int addReportCount(ReportDTO reportDTO) {
        try {
            System.out.println("member : " + reportDTO.getReportedMemberNo().toString());
            Member member = memberRepository.findById(reportDTO.getReportedMemberNo())
                    .orElseThrow(() -> new NotFoundException("존재하지않는 회원입니다."));

            int reportCnt = Integer.parseInt(member.getMemberReportCnt()) + 1;
            member.setMemberReportCnt(String.valueOf(reportCnt));

            return reportCnt;
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
