package com.restvet.RestVet.model.endereco;

import com.restvet.RestVet.model.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    @ManyToMany(mappedBy = "enderecos")
    private List<Usuario> usuarios;

}
