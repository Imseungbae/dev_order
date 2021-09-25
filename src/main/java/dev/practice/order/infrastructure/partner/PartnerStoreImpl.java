package dev.practice.order.infrastructure.partner;

import dev.practice.order.domain.partner.Partner;
import dev.practice.order.domain.partner.PartnerStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * infrastructure Layer에서는 @Component 이용
 */

@Slf4j
@Component
@RequiredArgsConstructor
public class PartnerStoreImpl implements PartnerStore {
    private final PartnerRepository partnerRepository;

    @Override
    public Partner store(Partner partner) {
        if(StringUtils.isEmpty(partner.getEmail())) throw new RuntimeException("empty email");
        if(StringUtils.isEmpty(partner.getPartnerName())) throw new RuntimeException("empty partnerName");
        if(StringUtils.isEmpty(partner.getBusinessNo())) throw new RuntimeException("empty businessNo");

        return partnerRepository.save(partner);
    }
}
