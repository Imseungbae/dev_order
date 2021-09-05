package dev.practice.order.domain.partner;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PartnerServiceImpl implements PartnerService{
    /** 도메인에서 서비스클래스가 가장 중요하다. 무슨 서비스인지 읽혀야한다. */
    /** 로우레벨로직은 인프라스트럭처레이어로 보낸다.*/

    private final PartnerStore partnerStore;
    private final PartnerReader partnerReader;

    @Override
    @Transactional
    public PartnerInfo registerPartner(PartnerCommand command) {
        // 1.command -> initPartner
        // 2. initPartner save to DB
        // 3. Partner -> PartnerInfo AND return
        /** 서비스로직은 이와같이 3줄이여야 한다. 그이상은 다 인프라스트럭처로 넘겨야함.**/

        var initPartner = command.toEntity();
        Partner partner = partnerStore.store(initPartner);
        return new PartnerInfo(partner);
    }

    @Override
    @Transactional
    public PartnerInfo getPartnerInfo(String partnerToken) {
        // 1.partnerToken -> Partner
        // Partner -> PartnerInfo AND return

        Partner partner = partnerReader.getPartner(partnerToken);
        return new PartnerInfo(partner);
    }

    @Override
    @Transactional
    public PartnerInfo enablePartner(String partnerToken) {
        // 1.parterToken -> Partner
        // Partner -> PartnerInfo AND return

        Partner partner = partnerReader.getPartner(partnerToken);
        partner.enable();
        return new PartnerInfo(partner);
    }

    @Override
    @Transactional
    public PartnerInfo disabledPartner(String partnerToken) {
        Partner partner = partnerReader.getPartner(partnerToken);
        partner.disable();
        return new PartnerInfo(partner);
    }
}
