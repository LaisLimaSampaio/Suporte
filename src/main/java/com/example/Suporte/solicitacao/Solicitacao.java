package com.example.Suporte.solicitacao;

import com.example.Suporte.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity(name = "solicitacoes")
@Table(name = "solicitacoes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Solicitacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private LocalDate dataCriacao;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private Status status;


    public Solicitacao(Solicitacao dados) {
        this.descricao = dados.getDescricao();
        this.dataCriacao = LocalDate.now();
        this.status = Status.A_FAZER;
    }

}
