package dev.practice.order.domain.partner;

public interface PartnerService {
    // Command 명령쪽, Criteria 조회성격 --- Info

    PartnerInfo registerPartner(PartnerCommand command);
    PartnerInfo getPartnerInfo(String partnerToken);
    PartnerInfo enablePartner(String partnerToken);
    PartnerInfo disabledPartner(String partnerToken);
}
