package br.com.cemil.library.dao;

import br.com.cemil.library.domain.Livro;
import br.com.cemil.library.exception.NaoExisteDaoException;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.List;

public class LivroDaoImpl implements LivroDao {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Livro livro) {
        entityManager.persist(livro);
    }

    @Override
    public void update(Livro livro) {
        entityManager.merge(livro);
    }

    @Override
    public void delete(Long id) {
        try {
            entityManager.remove(entityManager.getReference(Livro.class, id));
        } catch (EntityNotFoundException ex) {
            throw new NaoExisteDaoException("Curso não encontrado para id = " + id + ".");
        }
    }

    @Override
    public Livro findById(Long id) {
        Livro livro = entityManager.find(Livro.class, id);
        if (livro == null) {
            throw new NaoExisteDaoException("Curso não encontrado para id = " + id + ".");
        }
        return livro;
    }

    @Override
    public List<Livro> findAll() {
        return entityManager
            .createQuery("select l from Livro l", Livro.class)
            .getResultList();
    }
}

