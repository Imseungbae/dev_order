package dev.practice.order.interfaces.partner;

import dev.practice.order.application.partner.PartnerFacade;
import dev.practice.order.common.response.CommonResponse;
import dev.practice.order.domain.partner.PartnerCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(value="/api/v1/partners")
public class PartnerApiController {

    private PartnerFacade partnerFacade;

    @PostMapping
    public CommonResponse resgisterPartner(PartnerDto.RegisterResquest resquest) {
        // 1. dto -> command, criteria 변환
        var command = resquest.toCommand();
        // 2. Facade 호출
        var partnerInfo = partnerFacade.registerPartner(command);
        // 3. PartnerInfo -> Response 변환
        var response = new PartnerDto.RegisterResponse(partnerInfo);
        return CommonResponse.success(response);
    }
}
