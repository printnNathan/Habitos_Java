package com.habitos.api.services;

import com.habitos.api.domain.habito.Habito;
import com.habitos.api.domain.habitoCompleto.HabitoCompletoRequestDTO;
import com.habitos.api.domain.habitoCompleto.HabitoCompletoResponseDTO;
import com.habitos.api.domain.habitoCompleto.HabitoCompleto;
import com.habitos.api.repositories.HabitoRepository;
import com.habitos.api.repositories.HabitoCompletoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HabitoCompletoService {

    @Autowired
    private HabitoCompletoRepository habitoCompletoRepository;

    @Autowired
    private HabitoRepository habitoRepository;


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
}




