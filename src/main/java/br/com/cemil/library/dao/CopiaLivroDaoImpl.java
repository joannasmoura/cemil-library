package br.com.cemil.library.dao;


import br.com.cemil.library.domain.CopiaLivro;
import br.com.cemil.library.exception.NaoExisteDaoException;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.List;

public class CopiaLivroDaoImpl implements CopiaLivroDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(CopiaLivro copiaLivro) {
        entityManager.persist(copiaLivro);
    }

    @Override
    public void update(CopiaLivro copiaLivro) {
        entityManager.persist(copiaLivro);
    }

    @Override
    public void delete(Long id) {
        try {
            entityManager.remove(entityManager.getReference(CopiaLivro.class, id));
        } catch (EntityNotFoundException ex) {
            throw new NaoExisteDaoException("CopiaLivro não encontrada para id = " + id + ".");
        }
    }

    @Override
    public CopiaLivro findById(Long id) {
        CopiaLivro copiaLivro = entityManager.find(CopiaLivro.class, id);
        if (copiaLivro == null) {
            throw new NaoExisteDaoException("CopiaLivro não encontrada para id = " + id + ".");
        }
        return copiaLivro;
    }

    @Override
    public List<CopiaLivro> findAll() {
        return entityManager
            .createQuery("select cp from CopiaLivro cp", CopiaLivro.class)
            .getResultList();
    }
}
