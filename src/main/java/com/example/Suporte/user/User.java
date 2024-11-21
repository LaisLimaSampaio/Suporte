package com.example.Suporte.user;

import com.example.Suporte.solicitacao.Solicitacao;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.rmi.server.UID;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "users")
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Solicitacao> solicitacoes = new ArrayList<>();

    public User(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    public User(User dados) {
        this.nome = dados.getNome();
    }

}
