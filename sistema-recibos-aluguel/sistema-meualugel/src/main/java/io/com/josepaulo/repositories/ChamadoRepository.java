package io.com.josepaulo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.com.josepaulo.domain.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer>{


}
