package com.realdolmen.group7.repository.experiment;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ESOBG49 on 7/11/2017.
 */
public interface GenericDao <T, ENTITYID extends Serializable> {


    ENTITYID create(T newInstance);

    T findById(ENTITYID id);

    List<T> findAll();

    void update(T entity);

    void delete(T entity);

    void deleteById(ENTITYID id);

}
