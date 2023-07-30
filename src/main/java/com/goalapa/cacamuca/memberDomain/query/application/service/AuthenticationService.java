package com.goalapa.cacamuca.memberDomain.query.application.service;

import com.goalapa.cacamuca.memberDomain.command.application.dto.CustomUser;
import com.goalapa.cacamuca.memberDomain.query.domain.aggregate.entity.Member;
import com.goalapa.cacamuca.memberDomain.query.domain.repository.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthenticationService implements UserDetailsService {

    private final MemberMapper memberMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Member member = memberMapper.findByMemberId(username);

        if(member == null) {
            throw new UsernameNotFoundException("회원 정보가 존재하지 않습니다.");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(member.getMemberGrant()));

        CustomUser customUser = new CustomUser(member, authorities);

        return customUser;
    }

    public Map<String, List<String>> getPermitListMap() {

        Map<String, List<String>> permitListMap = new HashMap<>();
        List<String> adminPermitList = new ArrayList<>();
        List<String> memberPermitList = new ArrayList<>();

        memberPermitList.add("/member/my-page");
        memberPermitList.add("/member/secession");
        memberPermitList.add("/report/**");
        memberPermitList.add("/request/**");
        memberPermitList.add("/review/review");
        memberPermitList.add("/review/report");
        memberPermitList.add("/review/selectReviews");

        adminPermitList.add("/member/admin-page");
        adminPermitList.add("/member/admin-list");
        adminPermitList.add("/stat/**");
        adminPermitList.add("/admin-page/**");

        permitListMap.put("adminPermitList", adminPermitList);
        permitListMap.put("memberPermitList", memberPermitList);

        return permitListMap;
    }
}
