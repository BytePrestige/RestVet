package com.restvet.RestVet.model.midTables;

import com.restvet.RestVet.model.endereco.Endereco;
import com.restvet.RestVet.model.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

/**
 * @author Lincoln
 */
@Entity(name = "UsuarioEndereco")
@Table(name = "USUARIO_ENDERECO")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioEndereco {

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    @Id
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "ID_ENDERECO")
    @Id
    private Endereco endereco;

}
