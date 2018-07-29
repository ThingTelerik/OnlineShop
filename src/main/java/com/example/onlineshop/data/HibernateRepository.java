package com.example.onlineshop.data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

public class HibernateRepository<T> implements GenericRepository<T> {

    private  final SessionFactory sessionFactory;
    private Class<T> entityClass;

    public HibernateRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Class<T> getEntityClass() {
        return entityClass;
    }

    public void setEntityClass(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public List<T> getAll() {
        List<T> entities = new ArrayList<>();
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            CriteriaBuilder builder = session.getCriteriaBuilder();


            CriteriaQuery<T> criteriaQuery = builder.createQuery(getEntityClass());
            criteriaQuery.from(getEntityClass());

            entities = session.createQuery(criteriaQuery).getResultList();
            transaction.commit();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }


        return entities;
    }

    @Override
    public T getById(int id) {
        return null;
    }

    @Override
    public T create(T entity) {
        return null;
    }
}
