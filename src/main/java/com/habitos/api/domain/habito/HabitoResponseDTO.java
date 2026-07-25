package com.habitos.api.domain.habito;

import java.util.Date;
import java.util.UUID;

public record HabitoResponseDTO(UUID id, String nome, Date data_Ativacao, UUID fkUsuario) {

    public HabitoResponseDTO(Habito habito) {
        this(
                habito.getId(),
                habito.getNome(),
                habito.getData_ativacao(),
                habito.getUsuario().getId()
        );
    }
}
