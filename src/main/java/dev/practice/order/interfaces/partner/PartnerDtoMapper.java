package dev.practice.order.interfaces.partner;

import dev.practice.order.domain.partner.PartnerCommand;
import org.mapstruct.Mapper;

@Mapper
public interface PartnerDtoMapper {

    // 파트너DTO의 registerRequest객체를 PartnerCommand로 매핑시키겠다는 의미
    // 파라미터명이 동일하기때문에 전달이 된다.
    PartnerCommand of(PartnerDto.RegisterRequest request);
}
