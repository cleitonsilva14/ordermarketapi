package io.dev.ordermarketapi.mapper;

import io.dev.ordermarketapi.dto.OrderRequestDto;
import io.dev.ordermarketapi.dto.OrderResponseDto;
import io.dev.ordermarketapi.model.Order;

public class OrderMapper {

	// request para Order
	public static Order mapToOrder(OrderRequestDto request) {

		var order = Order.builder()
				.marketPlace(request.marketPlace())
				.document(request.document())
				.documentType(request.documentType())
				.buyerName(request.buyerName())
				.total(request.total())
				.build();


		return order;
	}

	public static OrderResponseDto mapToOrderResponse(Order order) {
		return new OrderResponseDto(
				order.getOrderId(),
				order.getMarketplaceId(),
				order.getMarketPlace(),
				order.getCreatedAt(),
				order.getStatus(),
				order.getBuyerName(),
				order.getDocumentType(),
				order.getDocument(),
				order.getTotal());
	}

}
