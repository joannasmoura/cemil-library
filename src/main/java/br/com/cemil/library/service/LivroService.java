package br.com.cemil.library.service;

import br.com.cemil.library.domain.Livro;

import java.util.List;

public interface LivroService {
    void save(Livro livro);

    void update(Long id, Livro livro);

    void delete(Long id);

    Livro findById(Long id);

    List<Livro> findAll();

}
