package com.example.backend.biblioteca.resources;

import com.example.backend.biblioteca.dto.request.UsuarioRequest;
import com.example.backend.biblioteca.dto.response.UsuarioResponse;
import com.example.backend.biblioteca.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    @ResponseStatus(code = CREATED)
    public UsuarioResponse salvarUsuario(@RequestBody UsuarioRequest request) {
        return usuarioService.salvarUsuario(request);
    }

    @GetMapping("/{usuarioId}")
    @ResponseStatus(code = OK)
    public UsuarioResponse buscarUsuarioPeloId(@PathVariable Long usuarioId) {
        return usuarioService.buscarUsuarioPeloId(usuarioId);
    }

    @GetMapping
    @ResponseStatus(code = OK)
    public List<UsuarioResponse> buscarUsuarioPeloNome(@RequestBody UsuarioRequest request) {
        return usuarioService.buscarUsuariosPeloNome(request.getNome());
    }
}
