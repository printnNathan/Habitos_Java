package com.habitos.api.domain.habitoCompleto;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public record HabitoCompletoResponseDTO(UUID id, UUID fk_habito, LocalDate data_conclusao) {

    public HabitoCompletoResponseDTO(HabitoCompleto habitoCompleto) {
        this(
                habitoCompleto.getId(),
                habitoCompleto.getHabito().getId(),
                habitoCompleto.getDataConclusao()
        );
    }

}
