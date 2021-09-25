package dev.practice.order.domain.partner;

/**
 * XX_Reader : 토큰(대체키)을 통해 도메인을 조회한다.
 */

public interface PartnerReader {
    Partner getPartner(String partnerToken);
}
