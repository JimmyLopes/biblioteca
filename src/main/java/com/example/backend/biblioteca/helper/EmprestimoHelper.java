package com.example.backend.biblioteca.helper;

import com.example.backend.biblioteca.dto.response.EmprestimoResponse;
import com.example.backend.biblioteca.dto.response.LivroResponse;
import com.example.backend.biblioteca.model.Emprestimo;
import com.example.backend.biblioteca.model.Livro;
import com.example.backend.biblioteca.model.Usuario;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmprestimoHelper {

    public Emprestimo createModel(Usuario usuario, List<Livro> livros) {
        return new Emprestimo()
                .setUsuario(usuario)
                .setDataDevolucao(LocalDate.now().plusDays(7L))
                .setLivros(livros);
    }

    public EmprestimoResponse createResponse(Usuario usuario, List<Livro> livros) {
        return new EmprestimoResponse()
                .setNomeUsurio(usuario.getNome())
                .setDataDevolucao(LocalDate.now().plusDays(7L))
                .setLivros(livros.stream().map(livro -> new LivroResponse()
                        .setNome(livro.getNome())
                        .setDisponivel(livro.getDisponivel())
                        .setMaiorIdade(livro.getMaiorIdade())).collect(Collectors.toList()));
    }
}
