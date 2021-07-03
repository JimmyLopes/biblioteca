package com.example.backend.biblioteca.dto.request;

import java.time.LocalDate;

public class UsuarioRequest {

    private String nome;
    private LocalDate dataNascimento;

    public String getNome() {
        return nome;
    }

    public UsuarioRequest setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public UsuarioRequest setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
        return this;
    }
}
