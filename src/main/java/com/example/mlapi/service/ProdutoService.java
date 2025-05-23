package com.example.mlapi.service;

import com.example.mlapi.entity.Produto;
import com.example.mlapi.repository.ProdutoRepository;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    public Optional<Produto> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public Produto salvar(Produto produto) {
        return repository.save(produto);
    }

    public Boolean deletar(Long id) {
        repository.deleteById(id);
        return true;
    }
}
