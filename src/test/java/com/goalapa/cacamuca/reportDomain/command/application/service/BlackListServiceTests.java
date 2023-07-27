package com.goalapa.cacamuca.reportDomain.command.application.service;

import com.goalapa.cacamuca.memberDomain.command.domain.aggregate.entity.Member;
import com.goalapa.cacamuca.memberDomain.command.domain.repository.MemberRepository;
import com.goalapa.cacamuca.reportDomain.command.application.dto.BlackListReleaseDTO;
import com.goalapa.cacamuca.reportDomain.command.domain.aggregate.entity.BlackList;
import com.goalapa.cacamuca.reportDomain.command.domain.repository.BlackListRepository;
import com.goalapa.cacamuca.reportDomain.command.domain.service.BlackListService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest
@Transactional
public class BlackListServiceTests {

    @Autowired
    BlackListService blackListService;

    @Autowired
    BlackListRepository blackListRepository;

    @Autowired
    MemberRepository memberRepository;

    // release blacklist
    @Test
    @DisplayName("블랙리스트 해제 확인")
    public void releaseBlackListTest() {

        // given
        BlackListReleaseDTO blackListReleaseDTO = new BlackListReleaseDTO();
        blackListReleaseDTO.setBlackListNo(1);
        blackListReleaseDTO.setMemberNo(1);

        // when
        blackListService.releaseBlackList(blackListReleaseDTO);


        // then
        Optional<BlackList> blackList = blackListRepository.findById(blackListReleaseDTO.getBlackListNo());
        boolean releaseDateCheck = blackList.get().getBlacklistRelDate().equals(LocalDate.now());

        Optional<Member> member = memberRepository.findById(blackListReleaseDTO.getMemberNo());
        boolean reportTypeCheck = member.get().getBlackListType().equals(false);

        Assertions.assertTrue(releaseDateCheck);
        Assertions.assertTrue(reportTypeCheck);
    }
}
