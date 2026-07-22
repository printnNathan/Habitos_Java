package com.habitos.api.repositories;

import com.habitos.api.domain.habito_completo.Habito_completo;
import com.habitos.api.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface Habito_CompletoRepository extends JpaRepository<Habito_completo, UUID> {

}