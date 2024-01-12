package com.byteprestige.restvet.repository;

import com.byteprestige.restvet.model.endereco.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Lincoln
 */
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
