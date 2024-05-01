package com.example.desafioRpe.controllers;

import com.example.desafioRpe.domain.dtos.AutenticacaoDto;
import com.example.desafioRpe.domain.dtos.LoginResponseDto;
import com.example.desafioRpe.domain.dtos.RegistroDto;
import com.example.desafioRpe.domain.entities.Usuario;
import com.example.desafioRpe.infra.security.TokenService;
import com.example.desafioRpe.repositories.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    private final AuthenticationManager authenticationManager;
    private final UsuarioRepository usuarioRepository;
    private final TokenService tokenService;

    @Autowired
    public AutenticacaoController(AuthenticationManager authenticationManager, UsuarioRepository usuarioRepository, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.usuarioRepository = usuarioRepository;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AutenticacaoDto autenticacaoDto) {
        var usuarioSenha = new UsernamePasswordAuthenticationToken(autenticacaoDto.login(), autenticacaoDto.senha());
        var autenticacao = authenticationManager.authenticate(usuarioSenha);

        var token = tokenService.gerarToken((Usuario) autenticacao.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDto(token));
    }

    @PostMapping("/registrar")
    public ResponseEntity registrar(@RequestBody @Valid RegistroDto registroDto) {
        if(this.usuarioRepository.findByLogin(registroDto.login()) != null) {
            return ResponseEntity.badRequest().build();
        }

        String senhaEncriptada = new BCryptPasswordEncoder().encode(registroDto.senha());
        Usuario usuario = new Usuario(registroDto.login(), senhaEncriptada, registroDto.perfil());

        this.usuarioRepository.save(usuario);

        return ResponseEntity.ok().build();
    }
}
