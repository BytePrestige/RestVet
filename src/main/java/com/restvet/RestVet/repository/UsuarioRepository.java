package com.restvet.RestVet.repository;

import com.restvet.RestVet.model.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Lincoln
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
