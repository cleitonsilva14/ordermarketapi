package io.dev.ordermarketapi.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import io.dev.ordermarketapi.enums.DocumentType;
import io.dev.ordermarketapi.enums.Marketplace;
import io.dev.ordermarketapi.enums.OrderStatus;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Dados de resposta do pedido")
public record OrderResponseDto(
		UUID orderId,
		String marketplaceId,
		Marketplace marketPlace,
		LocalDateTime createdAt,
		OrderStatus status,
		String buyerName,
		DocumentType documentType,
		String document,
		BigDecimal total) {

}
