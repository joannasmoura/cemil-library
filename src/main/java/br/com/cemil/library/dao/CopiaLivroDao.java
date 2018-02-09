package br.com.cemil.library.dao;

import br.com.cemil.library.domain.CopiaLivro;

import java.util.List;

public interface CopiaLivroDao {

    void save(CopiaLivro copiaLivro);

    void update(CopiaLivro copiaLivro);

    void delete(Long id);

    CopiaLivro findById(Long id);

    List<CopiaLivro> findAll();
}
