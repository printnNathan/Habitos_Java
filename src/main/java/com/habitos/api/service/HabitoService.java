package com.habitos.api.service;

import com.habitos.api.domain.habito.Habito;
import com.habitos.api.domain.habito.HabitoRequestDTO;
import com.habitos.api.domain.habito.HabitoResponseDTO;
import com.habitos.api.domain.usuario.Usuario;
import com.habitos.api.repositories.HabitoRepository;
import com.habitos.api.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

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

}
