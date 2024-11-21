package com.example.Suporte.controller;

import com.example.Suporte.service.SolicitacaoService;
import com.example.Suporte.solicitacao.Solicitacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "solicitacao")
public class SolicitacaoController {
    @Autowired
    SolicitacaoService service;

    @PostMapping
    public ResponseEntity<Solicitacao> criarSolicitacao(@RequestBody Solicitacao dados) {
        return ResponseEntity.ok().body(service.criarSolicitacao(new Solicitacao(dados)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Solicitacao> deletarSolicitacao(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.excluirSolicitacao(id));
    }

    @GetMapping
    public ResponseEntity<List<Solicitacao>> listarSolicitacoes() {
        return ResponseEntity.ok().body(service.listar());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Solicitacao> buscarSolicitacao(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Solicitacao> atualizarSolicitacao(@PathVariable Long id,@RequestBody Solicitacao dados ) {
        return ResponseEntity.ok().body(service.atualizar(id,dados));
    }




}
