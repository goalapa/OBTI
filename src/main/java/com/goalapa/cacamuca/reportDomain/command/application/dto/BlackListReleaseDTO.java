package com.goalapa.cacamuca.reportDomain.command.application.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class BlackListReleaseDTO {
    private Integer blackListNo;
    private Integer memberNo;
    private String memberId;
}
