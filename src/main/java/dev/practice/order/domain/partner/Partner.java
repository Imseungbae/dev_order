package dev.practice.order.domain.partner;

import dev.practice.order.common.util.TokenGenerator;
import dev.practice.order.domain.AbstractEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;

@Slf4j
@Entity
@NoArgsConstructor
@Getter
@Table(name = "partners")
public class Partner extends AbstractEntity {

    private final static String PREFIX_PARTNER = "ptn_";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String partnerToken; //pk와 동일한 토큰
    private String partnerName;
    private String businessNo;
    private String email;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Getter
    @RequiredArgsConstructor
    public enum Status{
        ENABLE("활성화"), DISABLE("비활성화");
        private final String description;
    }

    @Builder
    public Partner(String partnerName, String businessNo, String email) {
        // 아직은 빈스트링처리 없음.
        if(StringUtils.isEmpty(email)) throw new RuntimeException("empty email");
        if(StringUtils.isEmpty(partnerName)) throw new RuntimeException("empty partnerName");
        if(StringUtils.isEmpty(businessNo)) throw new RuntimeException("empty businessNo");

        // 랜덤토큰 => 아파치유틸 사용
        this.partnerToken = TokenGenerator.randomCharacterWithPrefix(PREFIX_PARTNER);
        this.partnerName = partnerName;
        this.businessNo = businessNo;
        this.email = email;
        this.status = Status.ENABLE;
    }

    public void enable() {
        this.status = Status.ENABLE;
    }

    public void disable() {
        this.status = Status.DISABLE;
    }
}
