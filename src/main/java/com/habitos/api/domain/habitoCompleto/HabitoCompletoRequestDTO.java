package com.habitos.api.domain.habitoCompleto;

import java.util.Date;
import java.util.UUID;

public record HabitoCompletoRequestDTO(UUID id, UUID fk_habito, Date data_conclusao) {
}

//record é uma classe simplificada e imutável projetada especificamente para armazenar e transportar dados
