package com.habitos.api.controller;

import com.habitos.api.domain.habito.Habito;
import com.habitos.api.domain.habito.HabitoRequestDTO;
import com.habitos.api.domain.habito.HabitoResponseDTO;
import com.habitos.api.service.HabitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

}
