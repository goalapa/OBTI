package com.goalapa.cacamuca.reportDomain.command.infrastructure.service;

import com.goalapa.cacamuca.memberDomain.command.domain.repository.MemberRepository;
import com.goalapa.cacamuca.reportDomain.command.application.dto.ReportCreateDTO;
import com.goalapa.cacamuca.reportDomain.command.domain.repository.ReportRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
public class ReportCheckNullServiceTests {
    // 피신고자, 리뷰가 null이 아닌지 확인

    @Autowired
    ReportCheckNullServiceImpl reportCheckNullService;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    ReportRepository reportRepository;

    @Test
    @DisplayName("피신고자 null인 것 확인")
    public void reportCheckNullMemberTest() {

        // given
        ReportCreateDTO reportCreateDTO = new ReportCreateDTO();
        reportCreateDTO.setReportedMemberNo(Integer.MAX_VALUE);
        reportCreateDTO.setReviewNo(1);
        reportCreateDTO.setReportType(2);

        // when & then
        Assertions.assertThrows(RuntimeException.class, () -> reportCheckNullService.checkNotNull(reportCreateDTO));
    }

    @Test
    @DisplayName("피신고자 null이 아닌 것 확인")
    public void reportCheckNotNullMemberTest() {

        // given
        ReportCreateDTO reportCreateDTO = new ReportCreateDTO();
        reportCreateDTO.setReportedMemberNo(1);
        reportCreateDTO.setReviewNo(1);
        reportCreateDTO.setReportType(2);

        // when
        boolean check = reportCheckNullService.checkNotNull(reportCreateDTO);

        // then
        Assertions.assertTrue(check);
    }
}
