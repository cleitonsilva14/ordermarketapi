package io.dev.ordermarketapi.dto;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import io.dev.ordermarketapi.enums.DocumentType;
import io.dev.ordermarketapi.enums.Marketplace;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

class OrderRequestDtoValidationTest {

	private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

	@Test
	void rejectsMissingAndInvalidRequiredFields() {
		var request = new OrderRequestDto(null, " ", null, "", null);

		Set<String> invalidProperties = validator.validate(request).stream()
				.map(violation -> violation.getPropertyPath().toString())
				.collect(Collectors.toSet());

		assertTrue(invalidProperties.containsAll(Set.of("marketPlace", "buyerName", "documentType", "document", "total")));
	}

	@Test
	void acceptsAValidRequest() {
		var request = new OrderRequestDto(Marketplace.values()[0], "Buyer", DocumentType.CPF, "12345678901",
				new BigDecimal("10.00"));

		assertTrue(validator.validate(request).isEmpty());
	}
}