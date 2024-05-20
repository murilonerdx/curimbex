package com.murilonerdx.curimbex.model;

import com.murilonerdx.curimbex.response.PontoResponse;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ponto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomePonto;
	private String toque;
	private String letra;
	private String createdBy;
	private LocalDateTime updatedAt = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));

	public PontoResponse toResponse(){
		return new PontoResponse(
				this.id,
				this.nomePonto,
				this.toque,
				this.letra,
				null,
				this.createdBy,
				this.updatedAt
		);
	}
}
