package ru.chabanov.javaee.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.chabanov.javaee.entity.Category;
import ru.chabanov.javaee.entity.Order;


import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.Collection;


@Stateless
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class CategoryRepository extends AbstractRepository<Category> implements Serializable {

    private static Logger logger = LoggerFactory.getLogger(CategoryRepository.class);

    @Override
    @SuppressWarnings("unchecked")
    public Collection<Category> getAll() {
        logger.info("Get all categories");
        return entityManager.createQuery("FROM Category AS c LEFT JOIN FETCH c.products").getResultList();

//        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Category> query = builder.createQuery(Category.class);
//        Root<Category> from = query.from(Category.class);
//        query.select(from);
//        return entityManager.createQuery(query).getResultList();
    }

        @Override
    public Category getById(long id) {
        logger.info("Get category with id {}", id);
        return (Category) entityManager.createQuery("select c from Category c LEFT JOIN FETCH c.products  where c.id = :id")
                .setParameter("id",id)
                .getResultList().get(0);
    }


}
