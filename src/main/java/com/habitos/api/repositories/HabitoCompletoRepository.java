package com.habitos.api.repositories;

import com.habitos.api.domain.habitoCompleto.HabitoCompleto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.UUID;
import java.util.Optional;


public interface HabitoCompletoRepository extends JpaRepository<HabitoCompleto, UUID> {

    boolean existsByHabitoIdAndDataConclusao(UUID  habitoId, LocalDate dataConclusao);

    void deleteByHabitoIdAndDataConclusao(UUID  habitoId, LocalDate dataConclusao);

    Optional<HabitoCompleto> findByHabitoIdAndDataConclusao(UUID habitoId, LocalDate dataConclusao);

}