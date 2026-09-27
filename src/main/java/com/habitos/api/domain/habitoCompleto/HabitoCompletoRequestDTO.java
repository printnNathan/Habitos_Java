package com.habitos.api.domain.habitoCompleto;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public record HabitoCompletoRequestDTO(UUID id, UUID fk_habito, LocalDate data_conclusao) {
}

//record é uma classe simplificada e imutável projetada especificamente para armazenar e transportar dados
