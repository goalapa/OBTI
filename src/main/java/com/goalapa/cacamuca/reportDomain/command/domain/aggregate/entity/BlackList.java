package com.goalapa.cacamuca.reportDomain.command.domain.aggregate.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "blacklist")
public class BlackList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blacklist_no")
    private Integer blacklistNo;

    @Column(name = "blacklist_reg_date")
    private LocalDate blacklistRegDate;

    @Column(name = "blacklist_rel_date")
    private LocalDate blacklistRelDate;

    @Column(name = "member_no")
    private Integer memberNo;

    public BlackList(Integer memberNo, LocalDate blacklistRegDate, LocalDate blacklistRelDate) {
        this.memberNo = memberNo;
        this.blacklistRegDate = blacklistRegDate;
        this.blacklistRelDate = blacklistRelDate;
    }

    public BlackList() {

    }
}
