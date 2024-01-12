package com.byteprestige.restvet.model.usuario;

import jakarta.validation.constraints.NotNull;

/**
 * @author Lincoln
 */
public record DadosAtualizadoUsuario(
        @NotNull
        Long id,
        String nome,
        String email,
        String senha,
        String telefoneUsuario
) {
}
