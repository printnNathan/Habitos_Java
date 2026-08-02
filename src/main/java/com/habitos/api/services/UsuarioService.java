package com.habitos.api.services;

import com.habitos.api.repositories.HabitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private HabitoRepository habitoRepository;


}
