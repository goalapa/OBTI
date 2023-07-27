package com.goalapa.cacamuca.memberDomain.command.application.controller;

import com.goalapa.cacamuca.memberDomain.command.domain.aggregate.entity.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

@SpringBootTest
@ContextConfiguration
@AutoConfigureMockMvc
class CommandMemberControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    private Member member;

    @BeforeEach
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

//    @Test
//    void registration() throws Exception {
//        mvc.perform(MockMvcRequestBuilders
//                        .post("/member/registration")
//
//                )
//                .andExpect(MockMvcResultMatchers.status().is3xxRedirection());
//    }

    @Test
    void changeTempPassword() {
    }

    @Test
    void modifyMemberInfo() {
    }

    @Test
    void modifyMemberPassword() {
    }

    @Test
    void secession() {
    }
}