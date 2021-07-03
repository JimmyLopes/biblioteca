package com.example.backend.biblioteca.services;

import com.example.backend.biblioteca.dto.request.EmprestimoRequest;
import com.example.backend.biblioteca.dto.response.EmprestimoResponse;
import com.example.backend.biblioteca.exception.BusinessException;
import com.example.backend.biblioteca.helper.EmprestimoHelper;
import com.example.backend.biblioteca.model.Livro;
import com.example.backend.biblioteca.model.Usuario;
import com.example.backend.biblioteca.repositories.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Autowired
    private EmprestimoHelper helper;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private LivroService livroService;

    public EmprestimoResponse salvarEmprestimo(Long usuarioId, EmprestimoRequest request) {
        Usuario usuario = usuarioService.getUsuario(usuarioId);
        List<Livro> livros = request.getLivros().stream().map(livroId -> livroService.getLivro(livroId)).collect(Collectors.toList());
        validaDisponibilidadeLivros(livros);
        if (usuarioMenorIdade(usuario.getDataNascimento())) {
            validaEmprestimoPelaIdade(livros);
        }
        var emprestimo = helper.createModel(usuario, livros);
        emprestimoRepository.save(emprestimo);
        indisponibilizaLivrosEmprestados(livros);
        return helper.createResponse(usuario, livros);
    }

    public void indisponibilizaLivrosEmprestados(List<Livro> livros) {
        livros.forEach(livro -> livro.setDisponivel(Boolean.FALSE));
        livroService.salvarLivrosEmprestados(livros);
    }

    private void validaDisponibilidadeLivros(List<Livro> livros) {
        var todosDisponiveis = livros.stream().anyMatch(livro -> livro.getDisponivel().equals(true));
        if (!todosDisponiveis) throw new BusinessException("Nem todos os livros solicitados estão disponíveis.");
    }

    private void validaEmprestimoPelaIdade(List<Livro> livros) {
        var emprestimoNegadoPelaIdade = livros.stream().anyMatch(livro -> livro.getMaiorIdade().equals(true));
        if (emprestimoNegadoPelaIdade) throw new BusinessException("O usuário não tem idade suficiente para pegar os livros que deseja.");
    }

    private Boolean usuarioMenorIdade(LocalDate dataNascimento) {
        return Period.between(dataNascimento, LocalDate.now()).getYears() < 18;
    }
}
