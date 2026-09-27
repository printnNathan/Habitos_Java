package com.habitos.api.controller;

import com.habitos.api.domain.habitoCompleto.HabitoCompleto;
import com.habitos.api.domain.habitoCompleto.HabitoCompletoRequestDTO;
import com.habitos.api.domain.habitoCompleto.HabitoCompletoResponseDTO;
import com.habitos.api.repositories.HabitoCompletoRepository;
import com.habitos.api.services.HabitoCompletoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/habitoCompleto")
public class HabitoCompletoController {

    private final HabitoCompletoService habitoCompletoService;
    private final HabitoCompletoRepository habitoCompletoRepository;

    public HabitoCompletoController(HabitoCompletoService habitoCompletoService,
                                    HabitoCompletoRepository habitoCompletoRepository) {
        this.habitoCompletoService = habitoCompletoService;
        this.habitoCompletoRepository = habitoCompletoRepository;
    }

    @GetMapping
    public List<HabitoCompleto> listar() {
        return habitoCompletoService.listarCompletos();
    }

    @PostMapping
    public ResponseEntity<HabitoCompletoResponseDTO> criarConclusao(@RequestBody HabitoCompletoRequestDTO data) {
        HabitoCompletoResponseDTO conclusao = habitoCompletoService.criarConclusao(data);
        return ResponseEntity.ok(conclusao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HabitoCompletoResponseDTO> listarPorId(@PathVariable UUID id) {
        HabitoCompletoResponseDTO habitoCompleto = habitoCompletoService.listarPorId(id);
        return ResponseEntity.ok(habitoCompleto);
    }
}