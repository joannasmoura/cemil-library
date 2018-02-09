package br.com.cemil.library.dao;

import br.com.cemil.library.domain.Multa;

import java.util.List;

public interface MultaDao {

    void save(Multa multa);

    void update(Multa multa);

    void delete(Long id);

    Multa findById(Long id);

    List<Multa> findAll();
}
