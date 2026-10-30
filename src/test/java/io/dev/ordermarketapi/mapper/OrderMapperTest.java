package io.dev.ordermarketapi.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.jupiter.api.Test;

import io.dev.ordermarketapi.enums.DocumentType;
import io.dev.ordermarketapi.enums.Marketplace;
import io.dev.ordermarketapi.enums.OrderStatus;
import io.dev.ordermarketapi.model.Order;

class OrderMapperTest {

	@Test
	void mapsOrderToResponseDto() {
		var orderId = UUID.randomUUID();
		var createdAt = LocalDateTime.now();
		var total = new BigDecimal("42.50");
		var order = Order.builder()
				.orderId(orderId)
				.marketplaceId("marketplace-order-1")
				.marketPlace(Marketplace.values()[0])
				.createdAt(createdAt)
				.status(OrderStatus.values()[0])
				.buyerName("Buyer")
				.documentType(DocumentType.CPF)
				.document("12345678901")
				.total(total)
				.build();

		var response = OrderMapper.mapToOrderResponse(order);

		assertEquals(orderId, response.orderId());
		assertEquals("marketplace-order-1", response.marketplaceId());
		assertEquals(order.getMarketPlace(), response.marketPlace());
		assertEquals(createdAt, response.createdAt());
		assertEquals(order.getStatus(), response.status());
		assertEquals("Buyer", response.buyerName());
		assertEquals(DocumentType.CPF, response.documentType());
		assertEquals("12345678901", response.document());
		assertEquals(total, response.total());
	}
}