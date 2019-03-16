package ru.chabanov.javaee.repository;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.chabanov.javaee.entity.Order;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.Collection;

@Stateless
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class OrderRepository extends AbstractRepository<Order> implements Serializable {

private static Logger logger = LoggerFactory.getLogger(CategoryRepository.class);

@Override
@SuppressWarnings("unchecked")
public Collection<Order> getAll() {
        logger.info("Get all categories");
      //  return entityManager.createQuery("select o from Order o").getResultList();

    CriteriaBuilder builder = entityManager.getCriteriaBuilder();
    CriteriaQuery<Order> query = builder.createQuery(Order.class);
    Root<Order> from = query.from(Order.class);
    query.select(from);
    return entityManager.createQuery(query).getResultList();
        }

@Override
public Order getById(long id) {
        logger.info("Get category with id {}", id);
        return entityManager.find(Order.class, id);
        }

        }
