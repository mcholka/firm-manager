package com.firm.manager.dao.control;

import com.firm.manager.dao.entity.User;
import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Singleton
@Startup
public class TestUserInit {
    private static final Logger logger = Logger.getLogger(TestUserInit.class);

    @PersistenceContext
    private EntityManager entityManager;

    @PostConstruct
    public void init() {
        logger.info("Init TestUserInit");

        List<User> users = entityManager.createQuery("SELECT i FROM User i").getResultList();
        if(!users.isEmpty()) {
            return;
        }
        User admin = new User();
        admin.setLogin("admin");
        admin.setPassword("admin");
        admin.setRule("admin");

        entityManager.persist(admin);

        logger.info("Admin persisted");

        User user = new User();
        user.setLogin("user");
        user.setPassword("user");
        user.setRule("user");
        entityManager.persist(user);

        logger.info("User persisted");

        User other = new User();
        other.setLogin("other");
        other.setPassword("other");
        other.setRule("other");
        entityManager.persist(other);

        logger.info("Other persisted");
    }
}
