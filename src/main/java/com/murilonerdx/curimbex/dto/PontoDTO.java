package com.murilonerdx.curimbex.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PontoDTO {
	private String nomeDoPonto;
	private String descricao;
	private String letra;
	@NotEmpty
	private String toque;
	@NotEmpty(message = "Esse campo não pode ser vazio")
	private String createBy;
}
