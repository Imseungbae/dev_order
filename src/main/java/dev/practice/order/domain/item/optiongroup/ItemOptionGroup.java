package dev.practice.order.domain.item;

import com.google.common.collect.Lists;
import dev.practice.order.common.exception.InvalidParamException;
import dev.practice.order.domain.AbstractEntity;
import dev.practice.order.domain.item.option.ItemOption;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import java.util.List;

@Slf4j
@Getter
@Entity
@NoArgsConstructor
@Table(name = "item_option_groups")
public class ItemOptionGroup extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
    private Integer ordering;
    private String itemOptionGroupName;

    @Builder
    public ItemOptionGroup(Item item, Integer ordering, String itemOptionGroupName) {
        if(item == null) throw new InvalidParamException();
        if(ordering == null) throw new InvalidParamException();
        if(StringUtils.isBlank(itemOptionGroupName))
            throw new InvalidParamException("itemOptionGroup.itemOptionGroupName");

        this.item = item;
        this.ordering = ordering;
        this.itemOptionGroupName = itemOptionGroupName;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "itemOptionGroup", cascade = CascadeType.PERSIST)
    private List<ItemOption> itemOptionList = Lists.newArrayList();
}
