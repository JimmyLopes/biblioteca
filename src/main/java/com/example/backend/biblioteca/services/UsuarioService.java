package com.example.backend.biblioteca.services;

import com.example.backend.biblioteca.dto.request.UsuarioRequest;
import com.example.backend.biblioteca.dto.response.UsuarioResponse;
import com.example.backend.biblioteca.exception.BusinessException;
import com.example.backend.biblioteca.helper.UsuarioHelper;
import com.example.backend.biblioteca.model.Usuario;
import com.example.backend.biblioteca.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioHelper usuarioHelper;

    public UsuarioResponse salvarUsuario(UsuarioRequest request) {
        var usuario = usuarioHelper.createModel(request);
        usuarioRepository.save(usuario);
        return usuarioHelper.createResponse(usuario);
    }

    public List<UsuarioResponse> buscarUsuariosPeloNome(String nomeUsuario) {
        var usuarios = usuarioRepository.findAllByNomeContainingIgnoreCase(nomeUsuario);
        return usuarios.stream().map(usuario -> usuarioHelper.createResponse(usuario)).collect(Collectors.toList());
    }

    public UsuarioResponse buscarUsuarioPeloId(Long usuarioId) {
        var usuario = getUsuario(usuarioId);
        return usuarioHelper.createResponse(usuario);
    }

    public Usuario getUsuario(Long usuarioId) {
        return usuarioRepository.findById(usuarioId).orElseThrow(() -> new BusinessException("Usuário não encontrado"));
    }
}
