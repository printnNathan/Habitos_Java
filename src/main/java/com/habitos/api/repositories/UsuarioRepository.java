package com.habitos.api.repositories;

import com.habitos.api.domain.habito.Habito;
import com.habitos.api.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
}