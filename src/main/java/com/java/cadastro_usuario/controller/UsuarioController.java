package com.java.cadastro_usuario.controller;

import com.java.cadastro_usuario.business.UsuarioService;
import com.java.cadastro_usuario.infrastructure.entities.Usuario;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    // OBS: ResponseEntity é uma classe do Spring que representa toda a resposta HTTP
    // que será enviada de volta para o cliente
    // O método .ok() cria uma resposta com status 200 OK
    // .build() é usado para criar uma resposta sem corpo

    // atributo que servirá para que toda a classe UsuarioController
    // tenha acesso aos métodos do serviço  
    private final UsuarioService usuarioService;

    // Construtor
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    // O mais adequado é DTO como parâmetro, mas para simplificar, usaremos a entidade diretamente
    public ResponseEntity<Void> salvarUsuario(@RequestBody Usuario usuario) {
        // usar a instância injetada, não a referência estática
        usuarioService.salvarUsuario(usuario);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }

    @GetMapping("/buscar")
    public ResponseEntity<Usuario> buscarUsuarioPorEmail(@RequestParam String email) {
        Usuario usuario = usuarioService.buscarUsuarioPorEmail(email);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarUsuarioPorEmail(@RequestParam String email) {
        usuarioService.deletarUsuarioPorEmail(email);
        return ResponseEntity.ok().build();
    }


    // O @RequestParam serve para passar parâmetros na URL como ?parametro=valor
    // O @RequestBody serve para passar parâmetros no corpo da requisição
    @PutMapping
    public ResponseEntity<Void> atualizarUsuarioPorId(@RequestParam Integer id, @RequestBody Usuario usuario) {
        usuarioService.atualizarUsuarioPorId(id, usuario);
        return ResponseEntity.ok().build();
    }
}
