package com.habitos.api.domain.habito;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public record HabitoRequestDTO(String nome, Date data_ativacao, String fk_usuario) {
}

