package ru.chabanov.javaee.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.chabanov.javaee.entity.Common;
import ru.chabanov.javaee.entity.Product;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collection;
import java.util.List;


public abstract class AbstractRepository<T extends Common> {

    private static Logger logger = LoggerFactory.getLogger(AbstractRepository.class);

    @PersistenceContext(unitName = "ds")
    protected EntityManager entityManager;

    protected T getEntity(TypedQuery<T> query) {
        List<T> resultList = query.getResultList();
        if (resultList.isEmpty()) {
            return null;
        }
        return resultList.get(0);
    }

    public abstract T getById(long id);

    public abstract Collection<T> getAll();

    public T merge(T entity) {
        if (entity == null) {
            return null;
        }
        logger.info("Merge entity of class {} with id {}", entity.getClass().getSimpleName(), entity.getId());
        try {
            return entityManager.merge(entity);
        } catch (Exception ex) {
            logger.error("Error with entity class {}" , entity.getClass().getSimpleName(), ex);
            throw new IllegalStateException(ex);
        }
    }

    public void remove(T entity) {
        if (entity == null) {
            return;
        }
        logger.info("Removing entity of class {} with id {}", entity.getClass().getSimpleName(), entity.getId());
        try {
            Product attached = entityManager.find(Product.class, entity.getId());
            if (attached != null) {
                entityManager.remove(attached);
            }
        } catch (Exception ex) {
            logger.error("Error with entity class {}" , entity.getClass().getSimpleName(), ex);
            throw new IllegalStateException(ex);
        }
    }
}