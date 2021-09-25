package dev.practice.order.domain.item;

import dev.practice.order.common.exception.InvalidParamException;
import dev.practice.order.domain.AbstractEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;

@Slf4j
@Getter
@Entity
@NoArgsConstructor
@Table(name="item_options")
public class ItemOption extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "item_option_group_id")
    private ItemOptionGroup itemOptionGroup;
    private Integer ordering;
    private String itemOptionName;
    private Long itemOptionPrice;

    @Builder
    public ItemOption(ItemOptionGroup itemOptionGroup, Long itemOptionPrice, Integer ordering, String itemOptionName) {
        if(itemOptionGroup == null) throw new InvalidParamException("ItemOption.itemOptionGroup");
        if(ordering == null) throw new InvalidParamException("itemOption.ordering");
        if(StringUtils.isEmpty(itemOptionName)) throw new InvalidParamException();
        if(itemOptionPrice == null) throw new InvalidParamException("itemOption.price");

        this.itemOptionGroup = itemOptionGroup;
        this.ordering = ordering;
        this.itemOptionName = itemOptionName;
        this.itemOptionPrice = itemOptionPrice;
    }
}
