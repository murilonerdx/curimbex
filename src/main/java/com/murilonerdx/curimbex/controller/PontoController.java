package com.murilonerdx.curimbex.controller;

import com.murilonerdx.curimbex.dto.PontoDTO;
import com.murilonerdx.curimbex.response.PontoResponse;
import com.murilonerdx.curimbex.service.PontoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.PageRequest;


@RestController
@RequiredArgsConstructor
@RequestMapping("/pontos")
public class PontoController implements PontoI {

	private final PontoService pontoService;

	@PostMapping
	@Override
	public PontoResponse criarPonto(PontoDTO pontoDTO) {
		return pontoService.criarPonto(pontoDTO);
	}

	@GetMapping
	@Override
	public PageImpl<PontoResponse> buscarPontos(@RequestParam(
			value = "page",
			required = false,
			defaultValue = "0") int page,
												@RequestParam(
														value = "size",
														required = false,
														defaultValue = "10") int size) {
		PageRequest pageRequest = PageRequest.of(
				page,
				size,
				Sort.Direction.ASC,
				"nomePonto");

		return new PageImpl<>(
				pontoService.buscarPontos(pageRequest),
				pageRequest, size);
	}

	@GetMapping("nome/")
	@Override
	public PontoResponse buscarPorNome(@RequestParam String nome) {
		return pontoService.buscarPorNome(nome);
	}

	@GetMapping("/by-id/")
	@Override
	public PontoResponse buscarPorId(@PathVariable Long id) {
		return pontoService.buscarPorId(id);
	}

	@PutMapping
	@Override
	public PontoResponse atualizarPonto(@RequestBody PontoDTO pontoUpdate, @PathVariable Long id) {
		return pontoService.atualizarPonto(pontoUpdate, id);
	}

	@DeleteMapping
	@Override
	public void deletarPonto(Long id) {
		pontoService.deletarPonto(id);
	}

	@DeleteMapping("/clear")
	@Override
	public void deletarTodosPontos() {
		pontoService.deletarTodosPontos();
	}
}
