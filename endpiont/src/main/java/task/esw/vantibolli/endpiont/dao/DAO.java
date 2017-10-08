/*
 * Copyright (C) 2017 Ali Imran, All Rights Reserved.
 */
package task.esw.vantibolli.endpiont.dao;

import java.io.Serializable;
import java.util.List;
import task.esw.vantibolli.endpiont.dao.impl.AbstractDao;

/**
 * Data Access Object (DAO)
 * @see AbstractDao for implementations
 *
 * @author Ali Imran
 * @param <Id> generic for Identity datatype of Entity
 * @param <E> generic for Entity type
 */
public interface DAO<Id extends Serializable, E> {

    /**
     *
     * @param id
     * @return unique data entity of given @param id
     */
    public E getById(Id id);

    /**
     *
     * @return Collection of Data Entity
     */
    public List<E> list();

    /**
     *
     * @param entity
     * @return Data Entity as @param entity but after save (create) into db
     * @throws Exception if something goes wrong
     */
    public E save(E entity) throws Exception;

    /**
     *
     * @param entity
     * @return Data Entity as @param entity but after update (update) into db
     * @throws Exception if something goes wrong
     */
    public E update(E entity) throws Exception;

    /**
     *
     * @param id unique identity value for Data Entity Deleting 
     */
    public void delete(Id id);

    /**
     *
     * @return Collection of data for Reporting
     */
    public List<Object[]> report();

}
