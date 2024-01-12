package com.byteprestige.restvet.model.endereco;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.byteprestige.restvet.model.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Lincoln
 */
@Entity(name = "Endereco")
@Table(name = "endereco")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idEndereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEndereco;
    private String cep;
    private String rua;
    private int numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;
    private String complemento;

    @JsonIgnore
    @ManyToMany(mappedBy = "enderecos")
    private Set<Usuario> usuarios = new HashSet<>();

    public void atualizaEndereco(DadosAtualizadoEndereco dados){
        if (dados.cep() != null) {
            this.cep = dados.cep();
        }
        if (dados.rua() != null) {
            this.rua = dados.rua();
        }
        if (dados.numero() != 0) {
            this.numero = dados.numero();
        }
        if (dados.bairro() != null) {
            this.bairro = dados.bairro();
        }
        if (dados.cidade() != null) {
            this.cidade = dados.cidade();
        }
        if (dados.estado() != null) {
            this.estado = dados.estado();
        }
        if (dados.pais() != null) {
            this.pais = dados.pais();
        }
        if (dados.complemento() != null) {
            this.complemento = dados.complemento();
        }
    }

    public Endereco (DadosCadastroEndereco dados){
        this.cep = dados.cep();
        this.bairro = dados.bairro();
        this.cidade = dados.cidade();
        this.complemento = dados.complemento();
        this.estado = dados.estado();
        this.numero = dados.numero();
        this.pais = dados.pais();
        this.rua = dados.rua();
    }

}
