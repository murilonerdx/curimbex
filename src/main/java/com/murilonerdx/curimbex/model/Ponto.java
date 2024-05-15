package com.murilonerdx.curimbex.model;

import jakarta.persistence.Entity;
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
	private Long id;
	private String nomePonto;
	private String toque;
	private String letra;
	private String linkYoutube;
	private String createdBy;
	private LocalDateTime updatedAt = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
}
