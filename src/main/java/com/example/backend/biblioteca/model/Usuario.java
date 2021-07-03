package com.example.backend.biblioteca.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Usuario {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private LocalDate dataNascimento;

    public String getNome() {
        return nome;
    }

    public Usuario setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Usuario setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
        return this;
    }
}
