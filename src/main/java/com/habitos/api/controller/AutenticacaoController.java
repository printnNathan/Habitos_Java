package com.habitos.api.controller;

import com.habitos.api.domain.usuario.AutenticacaoDTO;
import com.habitos.api.domain.usuario.LoginResponseDTO;
import com.habitos.api.domain.usuario.RegistroDTO;
import com.habitos.api.domain.usuario.Usuario;
import com.habitos.api.infra.seguranca.TokenService;
import com.habitos.api.repositories.UsuarioRepository;
import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AutenticacaoDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.senha());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));

    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegistroDTO data) {

        if(this.repository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassoword = new BCryptPasswordEncoder().encode(data.senha());
        Usuario novoUsuario = new Usuario(data.login(), encryptedPassoword, data.role());

        this.repository.save(novoUsuario);

        return ResponseEntity.ok().build();

    }
}
