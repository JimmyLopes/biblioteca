package com.example.backend.biblioteca.repositories;

import com.example.backend.biblioteca.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findAllByNomeContainingIgnoreCase(String nomeUsuario);
}
