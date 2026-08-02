package com.habitos.api.controller;

import com.habitos.api.domain.habito.Habito;
import com.habitos.api.domain.habito.HabitoRequestDTO;
import com.habitos.api.domain.habito.HabitoResponseDTO;
import com.habitos.api.services.HabitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/habito")
public class HabitoController {

    @Autowired
    private HabitoService habitoService;

    public HabitoController(HabitoService habitoService) {
        this.habitoService = habitoService;
    }

    @GetMapping
    public List<Habito> listar() {
        return habitoService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<HabitoResponseDTO> criarHabito(@RequestBody HabitoRequestDTO data){
        HabitoResponseDTO habito = habitoService.criarHabito(data);
        return ResponseEntity.ok(habito);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<HabitoResponseDTO> atualizarHabito(@PathVariable UUID id, @RequestBody HabitoRequestDTO data) {
        HabitoResponseDTO habito = habitoService.atualizarHabito(id, data);

        return ResponseEntity.ok(habito);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarHabito(@PathVariable UUID id) {
        habitoService.deletarHabito(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HabitoResponseDTO> ListarPorId(@PathVariable UUID id) {
        HabitoResponseDTO habito = habitoService.listarPorId(id);
        return ResponseEntity.ok(habito);
    }

}
