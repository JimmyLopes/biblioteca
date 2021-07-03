package com.example.backend.biblioteca.resources;

import com.example.backend.biblioteca.dto.request.EmprestimoRequest;
import com.example.backend.biblioteca.dto.response.EmprestimoResponse;
import com.example.backend.biblioteca.services.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoResource {

    @Autowired
    private EmprestimoService emprestimoService;

    @PostMapping("/{usuarioId}")
    @ResponseStatus(code = CREATED)
    public EmprestimoResponse salvarEmprestimo(@PathVariable Long usuarioId, @RequestBody EmprestimoRequest request) {
        return emprestimoService.salvarEmprestimo(usuarioId, request);
    }

}