package com.restvet.RestVet.model.midTables;

import com.restvet.RestVet.model.endereco.Endereco;
import com.restvet.RestVet.model.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

/**
 * @author Lincoln
 */
@Entity(name = "UsuarioEndereco")
@Table(name = "usuario_endereco")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioEndereco {

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    @Id
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_endereco")
    @Id
    private Endereco endereco;

}
