package com.example.backend.biblioteca.helper;

import com.example.backend.biblioteca.dto.request.LivroRequest;
import com.example.backend.biblioteca.dto.response.LivroResponse;
import com.example.backend.biblioteca.model.Livro;
import org.springframework.stereotype.Component;

@Component
public class LivroHelper {

    public Livro createModel(LivroRequest request) {
        return new Livro()
                .setNome(request.getNome())
                .setMaiorIdade(request.getMaiorIdade())
                .setDisponivel(Boolean.TRUE);
    }

    public LivroResponse createResponse(Livro livro) {
        return new LivroResponse()
                .setNome(livro.getNome())
                .setDisponivel(livro.getDisponivel())
                .setMaiorIdade(livro.getMaiorIdade());
    }
}
