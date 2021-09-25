package dev.practice.order.application.partner;

import dev.practice.order.domain.notification.NotificationService;
import dev.practice.order.domain.partner.PartnerCommand;
import dev.practice.order.domain.partner.PartnerInfo;
import dev.practice.order.domain.partner.PartnerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PartnerFacade {

    private final PartnerService partnerService;
    private final NotificationService notificationService;

    public PartnerInfo registerPartner(PartnerCommand command) {
        // 1. 파트너 등록처리
        var partnerInfo = partnerService.registerPartner(command);
        // 2. 이메일 발송( 트랜잭션에 묶이지 않는다 )
        notificationService.sendEmail(partnerInfo.getEmail(), "send", "send email");
        return partnerInfo;
    }
}
