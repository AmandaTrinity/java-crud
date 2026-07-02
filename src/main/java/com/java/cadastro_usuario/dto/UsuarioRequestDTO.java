package com.java.cadastro_usuario.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioRequestDTO {
    // Nota: Existe um recurso mais recente no Java chamado Record 
    // (ex: public record UsuarioRequestDTO(String nome, String email) {}) 
    // que serve exatamente para dados puros de forma imutável sem precisar de Getters/Setters 
    // manuais ou do Lombok. Mas o uso de classes com Getter/Setter ainda é o padrão mais 
    // clássico em muitos projetos, então mantive

    private String nome;
    private String email;
}