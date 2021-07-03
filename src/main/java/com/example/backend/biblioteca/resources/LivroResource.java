package com.example.backend.biblioteca.resources;

import com.example.backend.biblioteca.dto.request.LivroRequest;
import com.example.backend.biblioteca.dto.response.LivroResponse;
import com.example.backend.biblioteca.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(path = "/livros")
public class LivroResource {

    @Autowired
    private LivroService livroService;

    @PostMapping
    @ResponseStatus(code = CREATED)
    public LivroResponse salvarLivro(@RequestBody LivroRequest request) {
        return livroService.salvarLivro(request);
    }

    @GetMapping
    @ResponseStatus(code = OK)
    public List<LivroResponse> buscarLivros(@RequestBody LivroRequest request) {
        return livroService.buscarLivrosPeloNome(request.getNome());
    }

    @GetMapping("/{livroId}")
    @ResponseStatus(code = OK)
    public LivroResponse buscarLivroPeloId(@PathVariable Long livroId) {
        return livroService.buscarLivroPeloId(livroId);
    }
}
