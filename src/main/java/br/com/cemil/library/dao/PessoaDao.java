package br.com.cemil.library.dao;

import br.com.cemil.library.domain.Pessoa;

import java.util.List;

public interface PessoaDao {

    void save(Pessoa pessoa);

    void update(Pessoa pessoa);

    void delete(Long id);

    Pessoa findById(Long id);

    List<Pessoa> findAll();
}
