package com.goalapa.cacamuca.memberDomain.command.domain.aggregate.vo;

public class PasswordVO {
    private String pwd;

    public PasswordVO(String str) {
        if(str.length() < 10) {
            throw new RuntimeException();

        }
    }

    public String getPwd(){
        return pwd;
    }
}
