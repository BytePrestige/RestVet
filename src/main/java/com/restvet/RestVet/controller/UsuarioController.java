package com.restvet.RestVet.controller;

import com.restvet.RestVet.model.usuario.DadosAtualizadoUsuario;
import com.restvet.RestVet.model.usuario.DadosCadastroUsuario;
import com.restvet.RestVet.model.usuario.DadosCompletoUsuario;
import com.restvet.RestVet.model.usuario.Usuario;
import com.restvet.RestVet.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * @author Lincoln
 */
@RestController
@RequestMapping("usuario")
public class UsuarioController {
    @Autowired
    private UsuarioRepository repository;

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var usuario = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosCompletoUsuario(usuario));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody DadosAtualizadoUsuario dados){
        var usuario = repository.getReferenceById(dados.id());
        usuario.atualizaInformacoes(dados);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody DadosCadastroUsuario dados, UriComponentsBuilder uriBuilder){

        var usuario = new Usuario(dados);
        repository.save(usuario);

        var uri = uriBuilder.path("usuario/{id}").buildAndExpand(usuario.getIdUsuario()).toUri();

        return ResponseEntity.created(uri).body(new DadosCompletoUsuario(usuario));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var user = repository.getReferenceById(id);
        repository.delete(user);
        return ResponseEntity.noContent().build();
    }
}