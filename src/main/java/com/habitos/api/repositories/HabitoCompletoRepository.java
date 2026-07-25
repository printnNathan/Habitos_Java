package com.habitos.api.repositories;

import com.habitos.api.domain.habitoCompleto.HabitoCompleto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HabitoCompletoRepository extends JpaRepository<HabitoCompleto, UUID> {

}