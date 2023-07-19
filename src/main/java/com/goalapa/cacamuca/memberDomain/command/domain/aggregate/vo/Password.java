package com.goalapa.cacamuca.memberDomain.command.domain.aggregate.vo;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import java.security.SecureRandom;

import org.springframework.security.crypto.password.PasswordEncoder;

@NoArgsConstructor
public class Password {


//    @Autowired
//    public Password(PasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }

    public String generateTemporalPassword() {

        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 13; i++) {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }

        return sb.toString();
    }
}
