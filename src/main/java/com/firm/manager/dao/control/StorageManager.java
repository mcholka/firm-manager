package com.firm.manager.dao.control;

import org.apache.log4j.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class StorageManager {
    private static final Logger logger = Logger.getLogger(StorageManager.class);

    @PersistenceContext
    private EntityManager entityManager;

    public <T> void persist(T entity) {
        logger.info("Persist entity " + entity);
        entityManager.persist(entity);
        entityManager.flush();
    }

    public <T> T update(T entity) {
        logger.info("Update entity: " + entity);
        entity = entityManager.merge(entity);
        entityManager.flush();
        return entity;
    }

    public <T> T find(Class<T> clazz, Object id) {
        logger.info("Try to find entity " + clazz.getSimpleName() + " by id " + id);
        T entity = entityManager.find(clazz, id);
        if (entity == null) {
            throw new NoResultException("Not found entity " + clazz.getSimpleName() + " by id " + id);
        }
        logger.info("Entity found");
        return entity;
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> findAll(Class<T> clazz) {
        String className = clazz.getSimpleName();
        logger.info("Find all by entity " + className);
        String queryAsString = "SELECT i FROM " + className + " i";
        Query query = entityManager.createQuery(queryAsString);
        return query.getResultList();
    }
}
