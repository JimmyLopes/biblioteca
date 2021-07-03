package com.example.backend.biblioteca.dto.response;

public class LivroResponse {

    private String nome;
    private Boolean disponivel;
    private Boolean maiorIdade;

    public String getNome() {
        return nome;
    }

    public LivroResponse setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public LivroResponse setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
        return this;
    }

    public Boolean getMaiorIdade() {
        return maiorIdade;
    }

    public LivroResponse setMaiorIdade(Boolean maiorIdade) {
        this.maiorIdade = maiorIdade;
        return this;
    }
}
