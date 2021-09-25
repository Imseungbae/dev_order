package dev.practice.order.domain.partner;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * command : 도메인 Layer에서 사용, 명령 파라미터
 * criteria : 도메인 Layer에서 사용, 조회 성격
 */

@Getter
@Builder
@ToString
public class PartnerCommand {

    private String partnerName;
    private String businessNo;
    private String email;

    public Partner toEntity() {
        return Partner.builder()
                .partnerName(partnerName)
                .businessNo(businessNo)
                .email(email)
                .build();
    }
}
