package io.dev.ordermarketapi.mapper;

import io.dev.ordermarketapi.dto.OrderRequestDto;
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

}
