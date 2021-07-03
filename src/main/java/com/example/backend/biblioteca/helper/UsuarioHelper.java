package com.example.backend.biblioteca.helper;

import com.example.backend.biblioteca.dto.request.UsuarioRequest;
import com.example.backend.biblioteca.dto.response.UsuarioResponse;
import com.example.backend.biblioteca.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioHelper {

    public Usuario createModel(UsuarioRequest request) {
        return new Usuario()
                .setNome(request.getNome())
                .setDataNascimento(request.getDataNascimento());
    }

    public UsuarioResponse createResponse(Usuario usuario) {
        return new UsuarioResponse()
                .setNome(usuario.getNome())
                .setDataNascimento(usuario.getDataNascimento());
    }
}
