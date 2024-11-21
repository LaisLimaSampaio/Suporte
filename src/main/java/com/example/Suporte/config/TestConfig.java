package com.example.Suporte.config;

import com.example.Suporte.repository.SolicitacaoRepository;
import com.example.Suporte.repository.UserRepository;
import com.example.Suporte.solicitacao.Solicitacao;
import com.example.Suporte.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("dev") // Restrito ao ambiente de desenvolvimento
@Configuration
public class TestConfig implements CommandLineRunner {

    @Autowired
    private SolicitacaoRepository solicitacaoRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        // Criando solicitações
        Solicitacao solicitacao1 = new Solicitacao(null, "Fazer tal", null, null, null);
        Solicitacao solicitacao2 = new Solicitacao(null, "Fazer coisa", null, null, null);

        // Criando o usuário
        User user = new User(null, "João");

        // Associando solicitações ao usuário
        solicitacao1.setUser(user);
        solicitacao2.setUser(user);
        user.getSolicitacoes().add(solicitacao1);
        user.getSolicitacoes().add(solicitacao2);

        // Salvando no banco de dados
        userRepository.save(user);
    }
}
