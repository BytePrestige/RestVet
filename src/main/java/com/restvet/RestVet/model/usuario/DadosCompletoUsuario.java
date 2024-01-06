package com.restvet.RestVet.model.usuario;

import com.restvet.RestVet.model.endereco.Endereco;

import java.util.List;

/**
 * @author Lincoln
 */
public record DadosCompletoUsuario(
        Long id,
        String nome,
        String email,
        String senha,
        String telefone,
        List<Endereco> enderecos
) {
    public DadosCompletoUsuario(Usuario usuario){
        this(usuario.getIdUsuario(), usuario.getNomeUsuario(),
                usuario.getEmail(), usuario.getSenha(),
                usuario.getTelefoneUsuario(), usuario.getEnderecos());
    }
}
