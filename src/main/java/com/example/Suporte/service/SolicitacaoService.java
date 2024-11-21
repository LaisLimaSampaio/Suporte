package com.example.Suporte.service;

import com.example.Suporte.repository.SolicitacaoRepository;
import com.example.Suporte.solicitacao.Solicitacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class SolicitacaoService {
    @Autowired
    SolicitacaoRepository repository;

    public Solicitacao criarSolicitacao(Solicitacao solicitacao) {
        return repository.save(solicitacao);
    }

    public Solicitacao excluirSolicitacao(Long id) {
        Optional<Solicitacao> solicitacaoDeletada = repository.findById(id);
        repository.deleteById(id);
        return solicitacaoDeletada.orElse(null);
    }
    public List<Solicitacao> listar() {
        return repository.findAll();
    }

    public Solicitacao buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Solicitacao atualizar(Long id, Solicitacao dados ) {
        Optional<Solicitacao> solicitacaoAntiga = repository.findById(id);

        Solicitacao SolicitacaoAtualizada = new Solicitacao(
                solicitacaoAntiga.get().getId(),
                dados.getDescricao() != null? dados.getDescricao() : solicitacaoAntiga.get().getDescricao(),
                solicitacaoAntiga.get().getDataCriacao(),
                solicitacaoAntiga.get().getUser(),
                dados.getStatus()!= null? dados.getStatus() : solicitacaoAntiga.get().getStatus()
        );
        return repository.save(SolicitacaoAtualizada);
    }
}
