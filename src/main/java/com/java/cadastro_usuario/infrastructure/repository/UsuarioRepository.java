package com.java.cadastro_usuario.infrastructure.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.java.cadastro_usuario.infrastructure.entities.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    // findBy + Email(por baixo dos panos)
    // O jpa cria a query SELECT * FROM usuarios WHERE email = ?
    // Optional evita o NullPointerException quando o usuário não é encontrado   
    Optional<Usuario> findByEmail(String email);

    @Transactional
    void deleteByEmail(String email);
}
