package com.murilonerdx.curimbex.controller;

import com.murilonerdx.curimbex.dto.PontoDTO;
import com.murilonerdx.curimbex.response.PontoResponse;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PontoI {
	PontoResponse criarPonto(PontoDTO pontoDTO);

	PageImpl<PontoResponse> buscarPontos(int page, int size);

	PontoResponse buscarPorNome(String nome);

	PontoResponse buscarPorId(Long id);

	PontoResponse atualizarPonto(PontoDTO pontoUpdate, Long id);

	void deletarPonto(Long id);

	void deletarTodosPontos();
}
