package com.realdolmen.group7.repository.experiment;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

/**
 * Created by ESOBG49 on 7/11/2017.
 */
public class GenericImpl <T, ENTITYID extends Serializable> implements GenericDao< T , ENTITYID> {


    @PersistenceContext
    private EntityManager entityManager;


    private Class<T> myType;

    public GenericImpl(Class<T> myType) {
        this.myType = myType;
    }

    @Override
    public ENTITYID create(T entity) {
        entityManager.persist(entity);
        return (ENTITYID) entity;
    }

    @Override
    public T findById(ENTITYID id) {
        return (T) entityManager.find( myType, id);
    }


    //   Dit is een probleem
    @Override
    public List<T> findAll() {
        return null;
    }

    @Override
    public void update(T entity) {
        entityManager.merge(entity);
    }

    @Override
    public void delete(T entity) {
        entityManager.remove(entity);
    }

    @Override
    public void deleteById(ENTITYID id) {
        entityManager.remove(findById(id));
    }


}
