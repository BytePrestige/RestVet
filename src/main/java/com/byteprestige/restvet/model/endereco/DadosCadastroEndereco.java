package com.restvet.RestVet.model.endereco;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * @author Lincoln
 */
public record DadosCadastroEndereco(
        @NotBlank
        String cep,
        @NotBlank
        String rua,
        @NotNull
        @Min(value = 0, message = "Número da residência inválida")
        int numero,
        @NotBlank
        String bairro,
        @NotBlank
        String cidade,
        @NotBlank
        String estado,
        String pais,
        String complemento
) {
}
