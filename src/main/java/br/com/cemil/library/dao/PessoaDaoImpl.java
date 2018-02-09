package br.com.cemil.library.dao;

import br.com.cemil.library.domain.Pessoa;
import br.com.cemil.library.exception.NaoExisteDaoException;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.List;

public class PessoaDaoImpl implements PessoaDao{


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Pessoa pessoa) {
        entityManager.persist(pessoa);
    }

    @Override
    public void update(Pessoa pessoa) {
        entityManager.merge(pessoa);
    }

    @Override
    public void delete(Long id) {
        try {
            entityManager.remove(entityManager.getReference(Pessoa.class, id));
        } catch (EntityNotFoundException ex) {
            throw new NaoExisteDaoException("Pessoa não encontrada para id = " + id + ".");
        }
    }

    @Override
    public Pessoa findById(Long id) {
        Pessoa pessoa = entityManager.find(Pessoa.class, id);
        if (pessoa == null) {
            throw new NaoExisteDaoException("Pessoa não encontrada para id = " + id + ".");
        }
        return pessoa;
    }

    @Override
    public List<Pessoa> findAll() {
        return entityManager
            .createQuery("select p from Pessoa p", Pessoa.class)
            .getResultList();
    }
}

