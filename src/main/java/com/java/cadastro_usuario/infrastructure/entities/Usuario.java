package com.java.cadastro_usuario.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter //cria getId, getEmail...
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "usuario")
@Entity //Esta classe representa nosso 'banco'
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "nome")
    private String nome;
}
