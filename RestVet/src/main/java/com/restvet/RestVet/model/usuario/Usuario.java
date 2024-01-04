package com.restvet.RestVet.model.usuario;

import com.restvet.RestVet.model.endereco.Endereco;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lincoln
 */
@Table(name = "USUARIO")
@Entity(name = "Usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "ID")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String nome;

    @Email
    private String email;
    private String senha;
    private String telefone;

    @ManyToMany
    @JoinTable(
            name = "USUARIO_ENDERECO",
            joinColumns = @JoinColumn(name = "ID_USUARIO"),
            inverseJoinColumns = @JoinColumn(name = "ID_ENDERECO")
    )
    private List<Endereco> enderecos = new ArrayList<>();

}
