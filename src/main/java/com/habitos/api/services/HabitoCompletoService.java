package com.habitos.api.services;

import com.habitos.api.domain.habito.Habito;
import com.habitos.api.domain.habitoCompleto.HabitoCompletoRequestDTO;
import com.habitos.api.domain.habitoCompleto.HabitoCompletoResponseDTO;
import com.habitos.api.domain.habitoCompleto.HabitoCompleto;
import com.habitos.api.domain.usuario.Usuario;

import com.habitos.api.repositories.HabitoRepository;
import com.habitos.api.repositories.HabitoCompletoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class HabitoCompletoService {

   // @Autowired
    private final HabitoCompletoRepository habitoCompletoRepository;

    //@Autowired
    private final HabitoRepository habitoRepository;




    public List<HabitoCompleto> listarCompletos() {return habitoCompletoRepository.findAll();}

    public HabitoCompletoResponseDTO criarConclusao(HabitoCompletoRequestDTO data) {
        Habito habito = habitoRepository.findById(data.fk_habito())
                .orElseThrow(() -> new RuntimeException("Hábito não encontrado"));

        HabitoCompleto conclusao = new HabitoCompleto(habito, data.data_conclusao());
        habitoCompletoRepository.save(conclusao);

        return new HabitoCompletoResponseDTO(conclusao);
    }

    public HabitoCompletoResponseDTO listarPorId(UUID id) {
        HabitoCompleto habitoCompleto = habitoCompletoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("HábitoCompleto não encontrado"));

        return new HabitoCompletoResponseDTO(habitoCompleto);

    }

    public HabitoCompletoService(HabitoCompletoRepository habitoCompletoRepository,
                                 HabitoRepository habitoRepository) {
        this.habitoCompletoRepository = habitoCompletoRepository;
        this.habitoRepository = habitoRepository;
    }


    @Transactional
    public void marcarComoConcluido(UUID habitoId, Usuario usuarioLogado) {
        Habito habito = buscarHabitoDoUsuario(habitoId, usuarioLogado);

        boolean jaConcluido = habitoCompletoRepository
                .existsByHabitoIdAndDataConclusao(habito.getId(), LocalDate.now());

        if (jaConcluido) {
            throw new RuntimeException("Hábito já concluído hoje");
        }

        HabitoCompleto novaConclusao = new HabitoCompleto(habito, LocalDate.now());
        habitoCompletoRepository.save(novaConclusao);
    }

    @Transactional
    public void desmarcarConcluido(UUID habitoId, Usuario usuarioLogado) {
        Habito habito = buscarHabitoDoUsuario(habitoId, usuarioLogado);

        HabitoCompleto conclusao = habitoCompletoRepository
                .findByHabitoIdAndDataConclusao(habito.getId(), LocalDate.now())
                .orElseThrow(() -> new RuntimeException("Hábito não estava concluído hoje"));

        habitoCompletoRepository.delete(conclusao);
    }

    private Habito buscarHabitoDoUsuario(UUID habitoId, Usuario usuarioLogado) {
        Habito habito = habitoRepository.findById(habitoId)
                .orElseThrow(() -> {
                     throw new RuntimeException("Hábito não encontrado");
                });

        if (!habito.getUsuario().getId().equals(usuarioLogado.getId())) {
            throw new RuntimeException("Hábito não pertence ao usuário");
        }

        return habito;
    }

}




