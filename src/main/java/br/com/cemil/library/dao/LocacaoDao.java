package br.com.cemil.library.dao;

import br.com.cemil.library.domain.Locacao;

import java.util.List;

public interface LocacaoDao {

    void save(Locacao locacao);

    void update(Locacao locacao);

    void delete(Long id);

    Locacao findById(Long id);

    List<Locacao> findAll();
}
