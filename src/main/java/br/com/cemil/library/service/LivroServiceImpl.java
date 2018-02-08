package br.com.cemil.library.service;

import br.com.cemil.library.dao.LivroDao;
import br.com.cemil.library.domain.Livro;
import br.com.cemil.library.exception.IdNaoValidoServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LivroServiceImpl implements LivroService{

    @Autowired
    private LivroDao dao;

    @Override
    public void save(Livro livro) {

        dao.save(livro);
    }

    @Override
    public void update(Long id, Livro curso) {
        curso.setId(idValido(id));
        dao.findById(id);
        dao.update(curso);
    }

    @Override
    public void delete(Long id) {

        dao.delete(idValido(id));
    }

    @Override @Transactional(readOnly = true)
    public Livro findById(Long id) {

        return dao.findById(idValido(id));
    }

    @Override @Transactional(readOnly = true)
    public List<Livro> findAll() {

        return dao.findAll();
    }

    private Long idValido(Long id) {
        if (id <= 0) {
            throw new IdNaoValidoServiceException("Valor do campo id está invalido. Deve ser uma valor inteiro maior que zero.");
        }
        return id;
    }
}
