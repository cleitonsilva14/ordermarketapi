package io.dev.ordermarketapi.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import io.dev.ordermarketapi.enums.OrderStatus;
import io.dev.ordermarketapi.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID>, JpaSpecificationExecutor<Order> {

	List<Order> findByStatus(OrderStatus orderStatus);

}
