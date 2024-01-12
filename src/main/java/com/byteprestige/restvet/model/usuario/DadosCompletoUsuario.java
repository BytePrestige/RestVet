package com.byteprestige.restvet.model.usuario;

import com.byteprestige.restvet.model.endereco.Endereco;

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
