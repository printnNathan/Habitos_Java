package com.habitos.api.repositories;

import com.habitos.api.domain.habito.Habito;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface HabitoRepository extends JpaRepository<Habito, UUID> {
    List<Habito> findByUsuario_Id(UUID usuarioId);
}
