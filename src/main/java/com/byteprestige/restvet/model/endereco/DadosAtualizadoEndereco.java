package com.restvet.RestVet.model.endereco;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * @author Lincoln
 */
public record DadosAtualizadoEndereco(
        @NotNull
        long id,
        String cep,
        String rua,
        int numero,
        String bairro,
        String cidade,
        String estado,
        String pais,
        String complemento

) {
}
