package com.habitos.api.services;

import com.habitos.api.domain.habito.Habito;
import com.habitos.api.domain.habito.HabitoRequestDTO;
import com.habitos.api.domain.habito.HabitoResponseDTO;
import com.habitos.api.domain.usuario.Usuario;
import com.habitos.api.repositories.HabitoRepository;
import com.habitos.api.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HabitoService {


    @Autowired
    private HabitoRepository habitoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Habito> listarTodos() {
        return habitoRepository.findAll();
    }

    public HabitoResponseDTO criarHabito(HabitoRequestDTO data) {
        Usuario usuario = usuarioRepository.findById(data.fk_usuario())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Habito novoHabito = new Habito(data, usuario);
        habitoRepository.save(novoHabito);

        return new HabitoResponseDTO(novoHabito);
    }

    public HabitoResponseDTO atualizarHabito(UUID id, HabitoRequestDTO data) {
        Habito habito = habitoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hábito não encontrado"));

            if(data.nome() != null) {
                habito.setNome(data.nome());
            }

            if (data.data_ativacao() != null) {
                habito.setData_ativacao(data.data_ativacao());
            }

            habitoRepository.save(habito);

            return new HabitoResponseDTO(habito);
    }

    public void deletarHabito(UUID id) {
        Habito habito = habitoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hábito não encontrado"));

        habitoRepository.delete(habito);
    }

    public HabitoResponseDTO listarPorId(UUID id) {
        Habito habito = habitoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hábito não encontrado"));

        return new HabitoResponseDTO(habito);
    }

}
