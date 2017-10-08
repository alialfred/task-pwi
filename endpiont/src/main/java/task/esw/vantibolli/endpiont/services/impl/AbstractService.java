/*
 * Copyright (C) 2017 Ali Imran, All Rights Reserved.
 */
package task.esw.vantibolli.endpiont.services.impl;

import java.io.Serializable;
import java.util.List;
import task.esw.vantibolli.endpiont.dao.DAO;
import task.esw.vantibolli.endpiont.services.AService;

/**
 * Don't bother here either 
 *
 * @author Ali Imran
 * @param <Id>
 * @param <E>
 */
public class AbstractService<Id extends Serializable, E> implements AService<Id, E> {

    private final DAO<Id, E> dao;

    /**
     *
     * @param dao
     */
    public AbstractService(DAO<Id, E> dao) {
        this.dao = dao;
    }

    /**
     *
     * @param id
     */
    @Override
    public void delete(Id id) {
        dao.delete(id);
    }

    /**
     *
     * @param entity
     * @return
     * @throws Exception
     */
    @Override
    public E upate(E entity) throws Exception {
        return dao.update(entity);
    }

    /**
     *
     * @param entity
     * @return
     * @throws Exception
     */
    @Override
    public E save(E entity) throws Exception {
        return dao.save(entity);
    }

    /**
     *
     * @return
     */
    @Override
    public List<E> list() {
        return dao.list();
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public E getById(Id id) {
        return dao.getById(id);
    }

    /**
     *
     * @return
     */
    @Override
    public List<Object[]> report() {
        return dao.report();
    }

}
