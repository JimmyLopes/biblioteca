package com.example.backend.biblioteca.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Emprestimo {

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    private Usuario usuario;
    @OneToMany
    private List<Livro> livros;
    private LocalDate dataDevolucao;

    public Usuario getUsuario() {
        return usuario;
    }

    public Emprestimo setUsuario(Usuario usuario) {
        this.usuario = usuario;
        return this;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public Emprestimo setLivros(List<Livro> livros) {
        this.livros = livros;
        return this;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public Emprestimo setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
        return this;
    }
}
