package com.goalapa.cacamuca.reportDomain.command.application.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ReportDeleteDTO {
    private Integer reportNo;
    private Integer reviewNo;
    private Integer reportedMemberNo;
    private boolean isAccept;
}
