package com.byteprestige.restvet.model.endereco;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

/**
 * @author Lincoln
 */
public record DadosCompletoEndereco(
        @NotEmpty
        Long id,
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
        public DadosCompletoEndereco(Endereco endereco) {
                this(endereco.getIdEndereco(), endereco.getCep(), endereco.getRua(),
                        endereco.getNumero(), endereco.getBairro(), endereco.getCidade(),
                        endereco.getEstado(), endereco.getPais(), endereco.getComplemento()
                );
        }
}
