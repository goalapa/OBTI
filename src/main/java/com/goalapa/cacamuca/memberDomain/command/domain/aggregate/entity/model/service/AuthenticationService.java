package com.goalapa.cacamuca.memberDomain.command.domain.aggregate.entity.model.service;

import com.goalapa.cacamuca.memberDomain.command.domain.aggregate.entity.Member;
import com.goalapa.cacamuca.memberDomain.command.domain.aggregate.entity.model.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService implements UserDetailsService {

    private final MemberRepository memberRepository;
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Member> member = memberRepository.findByMemberId(username);

        if(!member.isPresent()) {
            throw new UsernameNotFoundException("회원 정보가 존재하지 않습니다.");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(member.get().getMemberGrant()));

//        CustomerUser customerUser = new Customer

        return null;
    }
}
