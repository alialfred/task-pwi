/*
 * Copyright (C) 2017 Ali Imran, All Rights Reserved.
 */
package task.esw.vantibolli.endpiont.dao.impl;

import java.io.InputStream;
import java.io.Serializable;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import task.esw.vantibolli.endpiont.dao.DAO;
import task.esw.vantibolli.validators.DataValidator;

/**
 * Abstract DAO an implemented class or Database CRUD operations
 *
 * @author Ali Imran
 * @param <Id> @see DAO
 * @param <E> @see DAO
 */
@Transactional
public abstract class AbstractDao<Id extends Serializable, E> implements DAO<Id, E> {

    private final Class<E> entityClass;
    private DataValidator<E> validator;

    /**
     *
     */
    @SuppressWarnings("unchecked")
    public AbstractDao() {
        this.entityClass = (Class<E>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    /**
     *
     * @param validator for data validations
     */
    public AbstractDao(DataValidator<E> validator) {
        this();
        this.validator = validator;
    }

    @Autowired
    private SessionFactory sessionFactory;

    /**
     *
     * @return
     */
    @SuppressWarnings("UseSpecificCatch")
    protected Session getSession() {
        Session session;

        try {
            session = sessionFactory.getCurrentSession();
        } catch (Exception e) {
            session = sessionFactory.openSession();
        }
        return session;
    }

    /**
     *
     * @param entity to delete
     */
    public void delete(E entity) {
        getSession().delete(entity);
        getSession().flush();
    }

    /**
     *
     * @return Criteria for entity class
     */
    protected Criteria createEntityCriteria() {
        return getSession().createCriteria(entityClass);
    }

    /**
     *
     * @return Entity Collection
     */
    @Override
    public List<E> list() {
        return createEntityCriteria().list();
    }

    /**
     *
     * @param id
     * @return Date Entity for specified @param id
     */
    @Override
    @SuppressWarnings("unchecked")
    public E getById(Id id) {
        E entity = (E) getSession().get(entityClass, id);
        return entity;
    }

    /**
     *
     * @param entity to save
     * @return saved entity
     * @throws Exception if something goes wrong
     */
    @Override
    public E save(E entity) throws Exception {
        if (validator != null) {
            validator.validate(entity);
        }
        getSession().save(entity);
        return entity;
    }

    /**
     *
     * @param entity to update
     * @return updated entity
     * @throws Exception if something goes wrong
     */
    @Override
    public E update(E entity) throws Exception {
        if (validator != null) {
            validator.validate(entity);
        }
        getSession().update(entity);
        return entity;
    }

    /**
     *
     * @param id Identity of Data Entity to delete
     */
    @Override
    public void delete(Id id) {
        this.delete(getById(id));
    }

    /**
     *
     * @return report data
     */
    @Override
    public List<Object[]> report() {
        try {
            Query query = getSession().createSQLQuery(readQuery());
            return query.list();
        } catch (Exception ex) {
            Logger.getLogger(AbstractDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Arrays.asList();
    }

    /**
     *
     * @return report query @see report
     * @throws Exception
     */
    protected String readQuery() throws Exception {
        byte[] b;
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("report.sql")) {
            b = new byte[is.available()];
            is.read(b);
        }
        return new String(b);
    }

}
