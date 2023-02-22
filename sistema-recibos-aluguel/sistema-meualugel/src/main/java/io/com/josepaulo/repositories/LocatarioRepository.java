package io.com.josepaulo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.com.josepaulo.domain.Locatario;

public interface LocatarioRepository extends JpaRepository<Locatario, Integer>{

}
