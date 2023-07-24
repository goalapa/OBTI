package com.goalapa.cacamuca.reportDomain.command.application.service;

import com.goalapa.cacamuca.memberDomain.command.domain.aggregate.entity.Member;
import com.goalapa.cacamuca.memberDomain.command.domain.repository.MemberRepository;
import com.goalapa.cacamuca.reportDomain.command.application.dto.ReportDTO;
import com.goalapa.cacamuca.reportDomain.command.application.dto.ReportDeleteDTO;
import com.goalapa.cacamuca.reportDomain.command.domain.aggregate.entity.BlackList;
import com.goalapa.cacamuca.reportDomain.command.domain.aggregate.entity.Report;
import com.goalapa.cacamuca.reportDomain.command.domain.aggregate.vo.ReportMemberVO;
import com.goalapa.cacamuca.reportDomain.command.domain.aggregate.vo.ReportedMemberVO;
import com.goalapa.cacamuca.reportDomain.command.domain.aggregate.vo.ReviewVO;
import com.goalapa.cacamuca.reportDomain.command.domain.repository.BlackListRepository;
import com.goalapa.cacamuca.reportDomain.command.domain.repository.ReportRepository;
import com.goalapa.cacamuca.reportDomain.command.domain.service.ReportService;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
public class ReportServiceImpl implements ReportService {
    private final ReportRepository reportRepository;
    private final MemberRepository memberRepository;
    private final BlackListRepository blackListRepository;

    public ReportServiceImpl(ReportRepository reportRepository, MemberRepository memberRepository, BlackListRepository blackListRepository) {
        this.reportRepository = reportRepository;
        this.memberRepository = memberRepository;
        this.blackListRepository = blackListRepository;
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

    @Override
    @Transactional
    public void saveBlackList(Integer reportedMemberNo) {
//        try {
//            Member member = memberRepository.findById(reportedMemberNo)
//                    .orElseThrow(() -> new NotFoundException("존재하지않는 회원입니다."));
//
//            if (!member.getmemberBlackListStatus()) {
//                BlackList blacklist = new BlackList(member.getMemberId(), LocalDate.now(), null);
//                blackListRepository.save(blacklist);
//            }
//
//        } catch (NotFoundException e) {
//            throw new RuntimeException(e);
//        }

    }
}
