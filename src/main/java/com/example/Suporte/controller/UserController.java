package com.example.Suporte.controller;

import com.example.Suporte.repository.UserRepository;
import com.example.Suporte.service.UserService;
import com.example.Suporte.solicitacao.Solicitacao;
import com.example.Suporte.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<User> criarUsuario(@RequestBody User dados) {
        return ResponseEntity.ok().body(service.criarUsuario(new User(dados)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deletarUser(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.excluirUser(id));
    }

    @GetMapping
    public ResponseEntity<List<User>> listarUsers() {
        return ResponseEntity.ok().body(service.listar());
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> buscarUser(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> atualizarUser(@PathVariable Long id,@RequestBody User dados ) {
        return ResponseEntity.ok().body(service.atualizar(id,dados));
    }
}
