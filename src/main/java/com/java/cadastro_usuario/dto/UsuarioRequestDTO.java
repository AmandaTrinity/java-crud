package com.java.cadastro_usuario.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

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

    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
    private String nome;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    private String email;
}