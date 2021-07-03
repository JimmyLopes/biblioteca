package com.example.backend.biblioteca.dto.response;

import java.time.LocalDate;
import java.util.List;

public class EmprestimoResponse {

    private String nomeUsurio;
    private LocalDate dataDevolucao;
    private List<LivroResponse> livros;

    public String getNomeUsurio() {
        return nomeUsurio;
    }

    public EmprestimoResponse setNomeUsurio(String nomeUsurio) {
        this.nomeUsurio = nomeUsurio;
        return this;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public EmprestimoResponse setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
        return this;
    }

    public List<LivroResponse> getLivros() {
        return livros;
    }

    public EmprestimoResponse setLivros(List<LivroResponse> livros) {
        this.livros = livros;
        return this;
    }
}
