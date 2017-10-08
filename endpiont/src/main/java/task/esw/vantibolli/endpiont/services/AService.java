/*
 * Copyright (C) 2017 Ali Imran, All Rights Reserved.
 */
package task.esw.vantibolli.endpiont.services;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Don't bother just @see DAO and Implementations for DAO
 *
 * @author Ali Imran
 * @param <Id>
 * @param <E>
 */
public interface AService<Id extends Serializable, E> {

    /**
     *
     * @return
     */
    public default Class<E> getEntityClass() {
        return (Class<E>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];

    }

    /**
     *
     * @param id
     */
    public void delete(Id id);

    /**
     *
     * @param entity
     * @return
     * @throws Exception
     */
    public E upate(E entity) throws Exception;

    /**
     *
     * @param entity
     * @return
     * @throws Exception
     */
    public E save(E entity) throws Exception;

    /**
     *
     * @return
     */
    public List<E> list();

    /**
     *
     * @param id
     * @return
     */
    public E getById(Id id);

    /**
     *
     * @return
     */
    public List<Object[]> report();
}
