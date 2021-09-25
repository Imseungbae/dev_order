package dev.practice.order.infrastructure.item;

import dev.practice.order.domain.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * xxxRepository : DB에 접근하는 느낌
 */
public interface ItemRepository extends JpaRepository<Item, Long> {
    Optional<Item> findByItemToken(String itemToken);
}
