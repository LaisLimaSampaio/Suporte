package com.example.Suporte.service;

import com.example.Suporte.repository.UserRepository;

import com.example.Suporte.user.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User criarUsuario(User user){
        return repository.save(user);
    }

    public User excluirUser(Long id) {
        Optional<User> UsuarioExcluido = repository.findById(id);
        repository.deleteById(id);
        return UsuarioExcluido.get();
    }

    public List<User> listar() {
        return repository.findAll();
    }

    public User buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public User atualizar(Long id, User dados) {
        Optional<User> userAntigo = repository.findById(id);

        User userAtualizado = new User(
                userAntigo.get().getId(),
                dados.getNome() != null? dados.getNome() : userAntigo.get().getNome()
        );
        return repository.save(userAtualizado);
    }
}
