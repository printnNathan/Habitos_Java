package com.habitos.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {

    /*
    @ExceptionHandler(HabitoNaoEncontradoException.class)
    public ResponseEntity<String> handleHabitoNaoEncontrado(HabitoNaoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(AcessoNegadoException.class)
    public ResponseEntity<String> handleAcessoNegado(AcessoNegadoException ex) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ex.getMessage());
    }

    @ExceptionHandler(HabitoJaConcluidoException.class)
    public ResponseEntity<String> handleHabitoJaConcluido(HabitoJaConcluidoException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    @ExceptionHandler(HabitoNaoConcluidoException.class)
    public ResponseEntity<String> handleHabitoNaoConcluido(HabitoNaoConcluidoException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }*/
}

