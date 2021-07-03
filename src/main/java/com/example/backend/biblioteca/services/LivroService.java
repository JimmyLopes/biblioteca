package com.example.backend.biblioteca.services;

import com.example.backend.biblioteca.dto.request.LivroRequest;
import com.example.backend.biblioteca.dto.response.LivroResponse;
import com.example.backend.biblioteca.exception.BusinessException;
import com.example.backend.biblioteca.helper.LivroHelper;
import com.example.backend.biblioteca.model.Livro;
import com.example.backend.biblioteca.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private LivroHelper helper;

    public LivroResponse salvarLivro(LivroRequest request) {
        var livro = helper.createModel(request);
        livroRepository.save(livro);
        return helper.createResponse(livro);
    }

    public List<LivroResponse> buscarLivrosPeloNome(String nomeLivro) {
        var livros = livroRepository.findLivroByNomeContains(nomeLivro);
        return livros.stream().map(livro -> helper.createResponse(livro)).collect(Collectors.toList());
    }

    public LivroResponse buscarLivroPeloId(Long livroId) {
        var livro = getLivro(livroId);
        return helper.createResponse(livro);
    }

    public Livro getLivro(Long livroId) {
        return livroRepository.findById(livroId).orElseThrow(() -> new BusinessException("Livro não encontrado"));
    }

    public void salvarLivrosEmprestados(List<Livro> livros) {
        livroRepository.saveAll(livros);
    }
}
