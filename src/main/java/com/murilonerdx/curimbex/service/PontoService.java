package com.murilonerdx.curimbex.service;

import com.murilonerdx.curimbex.dto.PontoDTO;
import com.murilonerdx.curimbex.model.Ponto;
import com.murilonerdx.curimbex.repository.PontoRepository;
import com.murilonerdx.curimbex.response.PontoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PontoService {
	private final PontoRepository repository;

 	public PontoResponse criarPonto(PontoDTO pontoDTO){
		Ponto modelSaved = repository.save(pontoDTO.toModel(null));
		return modelSaved.toResponse();
	}

	public List<PontoResponse> buscarPontos(Pageable pageable){
		 return repository.findAll(pageable)
				 .stream()
				 .map(Ponto::toResponse)
				 .collect(Collectors.toList());
	}

	public PontoResponse buscarPorNome(String nome){
		 return repository.findByNomePonto(nome).toResponse();
	}

	public PontoResponse buscarPorId(Long id){
		 return repository.findById(id).orElseThrow(() -> new RuntimeException("Não foi possivel encontrar Ponto com o id " + id)).toResponse();
	}

	public PontoResponse atualizarPonto(PontoDTO pontoUpdate, Long id){
		PontoResponse pontoResponse = buscarPorId(id);

		Ponto model = pontoUpdate.toModel(pontoResponse.getId());

		return repository.save(model).toResponse();
	}

	public void deletarPonto(Long id){
		 repository.deleteById(id);
	}

	public void deletarTodosPontos() {
		repository.deleteAll();
	}
}
