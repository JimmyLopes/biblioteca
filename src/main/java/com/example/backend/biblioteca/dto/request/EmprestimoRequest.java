package com.example.backend.biblioteca.dto.request;

import java.util.List;

public class EmprestimoRequest {

    private List<Long> livros;

    public List<Long> getLivros() {
        return livros;
    }

    public EmprestimoRequest setLivros(List<Long> livros) {
        this.livros = livros;
        return this;
    }
}
