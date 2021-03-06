package br.com.cemil.library.dao;

import br.com.cemil.library.domain.Livro;

import java.util.List;

public interface LivroDao {

    void save(Livro livro);

    void update(Livro livro);

    void delete(Long id);

    Livro findById(Long id);

    List<Livro> findAll();
}
