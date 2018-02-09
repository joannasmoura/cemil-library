package br.com.cemil.library.dao;

import br.com.cemil.library.domain.Multa;
import br.com.cemil.library.exception.NaoExisteDaoException;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.List;

public class MultaDaoImpl implements MultaDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Multa multa) {
        entityManager.persist(multa);
    }

    @Override
    public void update(Multa multa) {
        entityManager.merge(multa);
    }

    @Override
    public void delete(Long id) {
        try {
            entityManager.remove(entityManager.getReference(Multa.class, id));
        } catch (EntityNotFoundException ex) {
            throw new NaoExisteDaoException("Multa não encontrada para id = " + id + ".");
        }
    }

    @Override
    public Multa findById(Long id) {
        Multa multa = entityManager.find(Multa.class, id);
        if (multa == null) {
            throw new NaoExisteDaoException("Multa não encontrada para id = " + id + ".");
        }
        return multa;
    }

    @Override
    public List<Multa> findAll() {
        return entityManager
            .createQuery("select m from Multa m", Multa.class)
            .getResultList();
    }
}
