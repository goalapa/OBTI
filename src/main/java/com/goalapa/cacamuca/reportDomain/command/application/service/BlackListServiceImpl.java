package com.goalapa.cacamuca.reportDomain.command.application.service;

import com.goalapa.cacamuca.memberDomain.command.domain.aggregate.entity.Member;
import com.goalapa.cacamuca.memberDomain.command.domain.repository.MemberRepository;
import com.goalapa.cacamuca.reportDomain.command.application.dto.BlackListReleaseDTO;
import com.goalapa.cacamuca.reportDomain.command.domain.aggregate.entity.BlackList;
import com.goalapa.cacamuca.reportDomain.command.domain.repository.BlackListRepository;
import com.goalapa.cacamuca.reportDomain.command.domain.service.BlackListService;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class BlackListServiceImpl implements BlackListService {

    private final MemberRepository memberRepository;
    private final BlackListRepository blackListRepository;

    public BlackListServiceImpl(MemberRepository memberRepository, BlackListRepository blackListRepository) {
        this.memberRepository = memberRepository;
        this.blackListRepository = blackListRepository;
    }

    @Override
    @Transactional
    public void releaseBlackList(BlackListReleaseDTO blackListReleaseDTO) {
        try {
            System.out.println("service in");
            Member member = memberRepository.findById(blackListReleaseDTO.getMemberNo())
                    .orElseThrow(() -> new NotFoundException("존재하지않는 회원입니다."));

            BlackList blackList = blackListRepository.findById(blackListReleaseDTO.getBlackListNo())
                    .orElseThrow(() -> new NotFoundException("존재하지않는 블랙리스트입니다."));

            member.setBlackListType(false);
            blackList.setBlacklistRelDate(LocalDate.now());

        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
