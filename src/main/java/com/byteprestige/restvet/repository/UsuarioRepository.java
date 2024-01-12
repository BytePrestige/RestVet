package com.byteprestige.restvet.repository;

import com.byteprestige.restvet.model.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Lincoln
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
