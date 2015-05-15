package com.firm.manager.dao.control;

import com.firm.manager.dao.entity.Worker;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Stateless
public class WorkerManager {

    @PersistenceContext
    private EntityManager entityManager;

    public Optional<Worker> findBy(String personalData) {
        try {
            return Optional.of(
                    (Worker) entityManager.createQuery("" +
                            "SELECT i FROM Worker i " +
                            "WHERE i.personalData = :personalData").
                            setParameter("personalData", personalData).getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @SuppressWarnings("unchecked")
    public List<Worker> findNotDeleted() {
        return entityManager.createQuery("SELECT i FROM Worker i WHERE i.deleted = false").getResultList();
    }
}
