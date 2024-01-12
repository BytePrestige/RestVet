package com.restvet.RestVet.repository;

import com.restvet.RestVet.model.endereco.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Lincoln
 */
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
