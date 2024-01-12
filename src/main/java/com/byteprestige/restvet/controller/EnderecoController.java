package com.byteprestige.restvet.controller;

import com.byteprestige.restvet.model.endereco.*;
import com.byteprestige.restvet.model.midTables.DtoUsuarioEndereco;
import com.byteprestige.restvet.repository.EnderecoRepository;
import com.byteprestige.restvet.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;


/**
 * @author Lincoln
 */
@RestController
@RequestMapping("endereco")
public class EnderecoController {

    @Autowired
    private EnderecoRepository repositoryEndereco;

    @Autowired
    private UsuarioRepository repositoryUsuario;

    @GetMapping("/{id}")
    public ResponseEntity detalharEnderecoPeloId(@PathVariable Long id){
        var end = repositoryEndereco.getReferenceById(id);
        return ResponseEntity.ok(new DadosCompletoEndereco(end));
    }

    @GetMapping
    public ResponseEntity<List<DadosCompletoEndereco>> detalharTodosEnderecos(){
        return ResponseEntity.ok(repositoryEndereco.findAll().stream().map(DadosCompletoEndereco::new).toList());
    }

    @PostMapping()
    @Transactional
    public ResponseEntity criarEndereco(@RequestBody @Valid DadosCadastroEndereco dadosCadastroEndereco, UriComponentsBuilder uriBuilder){
        var endereco = new Endereco(dadosCadastroEndereco);
        repositoryEndereco.save(endereco);
        var uri = uriBuilder.path("endereco/{id}").buildAndExpand(endereco.getIdEndereco()).toUri();
        return ResponseEntity.created(uri).body(new DadosCompletoEndereco(endereco));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizadoEndereco dadosAtualizadoEndereco){
        var endereco = repositoryEndereco.getReferenceById(dadosAtualizadoEndereco.id());
        endereco.atualizaEndereco(dadosAtualizadoEndereco);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/usuario")
    @Transactional
    public ResponseEntity designarEnderecoParaUsuario(@RequestBody DtoUsuarioEndereco dtoUsuarioEndereco, UriComponentsBuilder uriComponentsBuilder){

        var endereco = repositoryEndereco.getReferenceById(dtoUsuarioEndereco.idEndereco());
        var usuario = repositoryUsuario.getReferenceById(dtoUsuarioEndereco.idUsuario());

        usuario.getEnderecos().add(endereco);
        endereco.getUsuarios().add(usuario);

        repositoryUsuario.save(usuario);

        return ResponseEntity.ok().build();
    }
    
    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity deleteEndereco(@PathVariable Long id){
        repositoryEndereco.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/usuario/delete")
    @Transactional
    public ResponseEntity deletaEnderecoDoUsuario(@RequestBody DtoUsuarioEndereco dtoUsuarioEndereco){
        var endereco = repositoryEndereco.getReferenceById(dtoUsuarioEndereco.idEndereco());
        var usuario = repositoryUsuario.getReferenceById(dtoUsuarioEndereco.idUsuario());

        usuario.getEnderecos().remove(endereco);

        repositoryUsuario.save(usuario);
        return ResponseEntity.noContent().build();
    }

}
