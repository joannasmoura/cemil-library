package br.com.cemil.library.dao;

import br.com.cemil.library.domain.Locacao;
import br.com.cemil.library.exception.NaoExisteDaoException;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.List;

public class LocacaoDaoImpl implements LocacaoDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Locacao locacao) {
        entityManager.persist(locacao);
    }

    @Override
    public void update(Locacao locacao) {
        entityManager.merge(locacao);
    }

    @Override
    public void delete(Long id) {
        try {
            entityManager.remove(entityManager.getReference(Locacao.class, id));
        } catch (EntityNotFoundException ex) {
            throw new NaoExisteDaoException("Locação não encontrada para id = " + id + ".");
        }
    }

    @Override
    public Locacao findById(Long id) {
        Locacao locacao = entityManager.find(Locacao.class, id);
        if (locacao == null) {
            throw new NaoExisteDaoException("Locação não encontrada para id = " + id + ".");
        }
        return locacao;
    }

    @Override
    public List<Locacao> findAll() {
        return entityManager
            .createQuery("select l from Locacao l", Locacao.class)
            .getResultList();
    }
}
