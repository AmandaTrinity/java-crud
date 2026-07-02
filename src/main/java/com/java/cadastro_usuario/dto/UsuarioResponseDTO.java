package com.java.cadastro_usuario.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioResponseDTO {
    private Integer id;
    private String nome;
    private String email;
}