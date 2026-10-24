package io.dev.ordermarketapi.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import io.dev.ordermarketapi.enums.DocumentType;
import io.dev.ordermarketapi.enums.Marketplace;
import io.dev.ordermarketapi.enums.OrderStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "tb_order")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID orderId;

	@Column(name = "marketplace_id")
	private String marketplaceId;

	@Column(name = "marketplace", nullable = false)
	@Enumerated(EnumType.STRING)
	private Marketplace marketPlace;

	@CreatedDate
	@Column(name = "created_at", nullable = false, updatable = false)
	private LocalDateTime createdAt;

	@Column(name = "order_status", nullable = false)
	@Enumerated(EnumType.STRING)
	private OrderStatus status;

	@Column(name = "buyer_name", nullable = false)
	private String buyerName;

	@Enumerated(EnumType.STRING)
	@Column(name = "document_type", nullable = false)
	private DocumentType documentType;

	@Column(name = "document")
	private String document;

	@Column(name = "total", precision = 10, scale = 2)
	private BigDecimal total = BigDecimal.ZERO;

	@PrePersist
	public void prePersist() {
	}

}
