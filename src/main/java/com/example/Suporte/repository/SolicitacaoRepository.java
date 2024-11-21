package com.example.Suporte.repository;

import com.example.Suporte.solicitacao.Solicitacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Long> {
}
