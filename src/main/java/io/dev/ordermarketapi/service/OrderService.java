package io.dev.ordermarketapi.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import io.dev.ordermarketapi.enums.OrderStatus;
import io.dev.ordermarketapi.exception.OrderNotFoundException;
import io.dev.ordermarketapi.model.Order;
import io.dev.ordermarketapi.repository.OrderRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

	private final OrderRepository orderRepository;

	public Order save(Order order) {

		var marketplaceFlag = order.getMarketPlace().name().substring(0, 4);
		var marketplaceUUID = UUID.randomUUID().toString().substring(0, 10).replace("-", "").toUpperCase();

		order.setMarketplaceId("%s-%s".formatted(marketplaceFlag, marketplaceUUID));
		order.setStatus(OrderStatus.PENDING);

		return orderRepository.save(order);
	}

	public List<Order> findAll() {
		return orderRepository.findAll();
	}

	public Order findByUUID(UUID uuid) {
		return orderRepository.findById(uuid)
				.orElseThrow(() -> new OrderNotFoundException("Order not found with UUID: " + uuid));
	}

	public Order invoiceOrder(UUID uuid) {

		Order order = this.findByUUID(uuid);

		if (order.getStatus() != OrderStatus.PAID_WAITING_SHIP) {
			throw new IllegalStateException("Order cannot be invoiced from status: " + order.getStatus());
		}

		order.setStatus(OrderStatus.INVOICED);

		return this.save(order);

	}

}
