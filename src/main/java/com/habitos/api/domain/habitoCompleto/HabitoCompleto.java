package com.habitos.api.domain.habitoCompleto;

import com.habitos.api.domain.habito.Habito;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;
import java.util.UUID;

@Getter
@Entity
@Table(name = "habitoCompleto")
public class HabitoCompleto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "fk_habito")
    private Habito habito;

    private Date dataConclusao;

    public HabitoCompleto() {}

    public HabitoCompleto(Habito habito, Date dataConclusao) {
        this.habito = habito;
        this.dataConclusao = dataConclusao;

    }
}
