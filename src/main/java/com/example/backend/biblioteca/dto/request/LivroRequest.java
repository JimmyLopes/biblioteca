package com.example.backend.biblioteca.dto.request;

public class LivroRequest {

    private String nome;
    private Boolean maiorIdade;

    public String getNome() {
        return nome;
    }

    public LivroRequest setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public Boolean getMaiorIdade() {
        return maiorIdade;
    }

    public LivroRequest setMaiorIdade(Boolean maiorIdade) {
        this.maiorIdade = maiorIdade;
        return this;
    }
}
