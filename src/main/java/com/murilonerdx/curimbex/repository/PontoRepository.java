package com.murilonerdx.curimbex.repository;

import com.murilonerdx.curimbex.model.Ponto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PontoRepository extends JpaRepository<Ponto, Long> {
	Ponto findByNomePonto(String nomePonto);
}
