package io.dev.ordermarketapi.dto;

import java.math.BigDecimal;

import io.dev.ordermarketapi.enums.DocumentType;
import io.dev.ordermarketapi.enums.Marketplace;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Schema(description = "Payload para a criação de um novo Order")
public record OrderRequestDto (

		@NotNull
		Marketplace marketPlace,

		@NotBlank
		String buyerName,

		@NotNull
		DocumentType documentType,

		@NotBlank
		String document,

		@NotNull
		@Positive
		BigDecimal total

		) {

}
