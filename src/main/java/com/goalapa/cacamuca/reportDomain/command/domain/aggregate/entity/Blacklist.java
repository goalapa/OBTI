package com.goalapa.cacamuca.reportDomain.command.domain.aggregate.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "blacklist")
public class Blacklist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blacklist_no")
    private Integer blacklistNo;

    @Column(name = "blacklist_reg_date")
    private LocalDate blacklistRegDate;

    @Column(name = "blacklist_rel_date")
    private LocalDate blacklistRelDate;

    @Column(name = "member_no")
    private int memberNo;
}
