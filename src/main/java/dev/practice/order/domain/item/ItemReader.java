package dev.practice.order.domain.item;

import java.util.List;

/**
 * xxReader : 토큰(대체키)를 이용하여 도메인을 조회한다.
 */
public interface ItemReader {
    Item getItemBy(String itemToken);
    List<ItemInfo.ItemOptionGroupInfo> getItemOptionSeries(Item item);
}
