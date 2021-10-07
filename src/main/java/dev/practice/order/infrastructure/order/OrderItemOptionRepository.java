package dev.practice.order.infrastructure.order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemOption extends JpaRepository<OrderItemOption, Long> {
}
