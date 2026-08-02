package com.habitos.api.domain.usuario;

public record RegistroDTO(String login, String senha, UsuarioRole role) {
}
