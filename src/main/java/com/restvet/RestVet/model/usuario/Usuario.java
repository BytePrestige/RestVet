package com.restvet.RestVet.model.usuario;

import com.restvet.RestVet.model.endereco.Endereco;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lincoln
 */
@Table(name = "usuario")
@Entity(name = "Usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "ID")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    private String nomeUsuario, email, senha, telefoneUsuario;

    @ManyToMany
    @JoinTable(
            name = "usuario_endereco",
            joinColumns = @JoinColumn(name = "ID_USUARIO"),
            inverseJoinColumns = @JoinColumn(name = "ID_ENDERECO")
    )
    private List<Endereco> enderecos = new ArrayList<>();

    public void atualizaInformacoes(DadosAtualizadoUsuario dados){
        if (dados.nome() != null){
            this.nomeUsuario = dados.nome();
        }
        if (dados.telefoneUsuario() != null) {
            this.telefoneUsuario = dados.telefoneUsuario();
        }
        if (dados.email() != null) {
            this.email = dados.email();
        }
        if (dados.senha() != null) {
            this.senha = dados.senha();
        }
    }
    public Usuario(DadosCadastroUsuario usuario){
        this.email = usuario.email();
        this.senha = usuario.senha();
        this.nomeUsuario = usuario.nome();
        this.telefoneUsuario = usuario.telefone();
    }
}
