package com.java.cadastro_usuario.controller;

import com.java.cadastro_usuario.business.UsuarioService;
import com.java.cadastro_usuario.dto.UsuarioRequestDTO;
import com.java.cadastro_usuario.dto.UsuarioResponseDTO;
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
    public ResponseEntity<Void> salvarUsuario(@RequestBody UsuarioRequestDTO usuarioDTO) {
        // Convertemos dto em entidade
        Usuario usuario = Usuario.builder()
                .nome(usuarioDTO.getNome())
                .email(usuarioDTO.getEmail())
                .build();
        // Chama o serviço para salvar
        usuarioService.salvarUsuario(usuario);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> listarUsuarios() {
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        
        // Converte lista de entidades em lista de DTOs usando .map
        List<UsuarioResponseDTO> dtos = usuarios.stream()
                                    .map(usuario -> UsuarioResponseDTO.builder()
                                            .id(usuario.getId())
                                            .nome(usuario.getNome())
                                            .email(usuario.getEmail())
                                            .build())
                                    .collect(java.util.stream.Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/buscar")
    public ResponseEntity<UsuarioResponseDTO> buscarUsuarioPorEmail(@RequestParam String email) {
        Usuario usuario = usuarioService.buscarUsuarioPorEmail(email);

        // Convertemos entidade em dto
        UsuarioResponseDTO response = UsuarioResponseDTO.builder()
                .id(usuario.getId())
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .build();
                
        return ResponseEntity.ok(response);
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarUsuarioPorEmail(@RequestParam String email) {
        usuarioService.deletarUsuarioPorEmail(email);
        return ResponseEntity.ok().build();
    }


    // O @RequestParam serve para passar parâmetros na URL como ?parametro=valor
    // O @RequestBody serve para passar parâmetros no corpo da requisição
    @PutMapping
    public ResponseEntity<Void> atualizarUsuarioPorId(@RequestParam Integer id, @RequestBody UsuarioRequestDTO usuarioDTO) {
        // Convertemos dto em entidade
        Usuario usuario = Usuario.builder()
                .id(id)
                .nome(usuarioDTO.getNome())
                .email(usuarioDTO.getEmail())
                .build();

        usuarioService.atualizarUsuarioPorId(id, usuario);
        return ResponseEntity.ok().build();
    }
}
