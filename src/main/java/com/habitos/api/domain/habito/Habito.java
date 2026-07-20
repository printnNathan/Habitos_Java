package com.habitos.api.domain.habito;
import com.habitos.api.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Table(name = "habito")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Habito {

    @Id
    @GeneratedValue
    private UUID id;

    private String nome;
    private Date data_ativacao;

    @ManyToOne
    @JoinColumn(name = "fk_usuario")
    private Usuario usuario;

    public Habito(HabitoRequestDTO data, Usuario usuario) {
        this.nome = data.nome();
        this.data_ativacao = data.data_ativacao();
        this.usuario = usuario;
    }

}
