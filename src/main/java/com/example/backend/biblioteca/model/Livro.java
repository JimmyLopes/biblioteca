package com.example.backend.biblioteca.model;

import javax.persistence.*;

@Entity
@Table
public class Livro {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private Boolean disponivel;
    private Boolean maiorIdade;

    public String getNome() {
        return nome;
    }

    public Livro setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public Livro setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
        return this;
    }

    public Boolean getMaiorIdade() {
        return maiorIdade;
    }

    public Livro setMaiorIdade(Boolean maiorIdade) {
        this.maiorIdade = maiorIdade;
        return this;
    }
}
