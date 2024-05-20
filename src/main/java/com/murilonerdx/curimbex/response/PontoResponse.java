package com.murilonerdx.curimbex.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(
		toBuilder = true
)
public class PontoResponse {
	private Long id;
	private String nomePonto;
	private String toque;
	private String letra;
	private String linkYoutube;
	private String createdBy;
	private LocalDateTime updatedAt = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
}
