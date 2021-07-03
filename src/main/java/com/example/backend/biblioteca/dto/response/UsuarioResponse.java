package com.example.backend.biblioteca.dto.response;

import java.time.LocalDate;

public class UsuarioResponse {

    private String nome;
    private LocalDate dataNascimento;

    public String getNome() {
        return nome;
    }

    public UsuarioResponse setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public UsuarioResponse setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
        return this;
    }
}
