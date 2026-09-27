package com.habitos.api.controller;

import com.habitos.api.domain.habito.Habito;
import com.habitos.api.domain.habito.HabitoRequestDTO;
import com.habitos.api.domain.habito.HabitoResponseDTO;
import com.habitos.api.domain.usuario.Usuario;
import com.habitos.api.services.HabitoService;
import com.habitos.api.services.HabitoCompletoService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/habito")
public class HabitoController {

    private final HabitoService habitoService;
    private final HabitoCompletoService habitoCompletoService;

    public HabitoController(HabitoService habitoService, HabitoCompletoService habitoCompletoService) {
        this.habitoService = habitoService;
        this.habitoCompletoService = habitoCompletoService;
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

    @GetMapping
    public List<HabitoResponseDTO> listar(@AuthenticationPrincipal Usuario usuarioLogado) {
        return habitoService.listarPorUsuario(usuarioLogado.getId());
    }

    @PostMapping("/{id}/completo")
    public ResponseEntity<Void> marcarComoConcluido(@PathVariable UUID id,
                                                    @AuthenticationPrincipal Usuario usuarioLogado) {
        habitoCompletoService.marcarComoConcluido(id, usuarioLogado);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}/completo")
    public ResponseEntity<Void> desmarcarConcluido(@PathVariable UUID id,
                                                   @AuthenticationPrincipal Usuario usuarioLogado) {
        habitoCompletoService.desmarcarConcluido(id, usuarioLogado);
        return ResponseEntity.noContent().build();
    }
}