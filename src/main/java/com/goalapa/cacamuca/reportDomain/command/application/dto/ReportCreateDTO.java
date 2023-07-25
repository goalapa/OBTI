package com.goalapa.cacamuca.reportDomain.command.application.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ReportCreateDTO {
    private Integer reviewNo;
    private Integer reportedMemberNo;
    private Integer reportType;
}