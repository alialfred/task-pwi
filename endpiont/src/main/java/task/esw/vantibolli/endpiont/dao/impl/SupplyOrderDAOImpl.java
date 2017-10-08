/*
 * Copyright (C) 2017 Ali Imran, All Rights Reserved.
 */
package task.esw.vantibolli.endpiont.dao.impl;

import org.springframework.stereotype.Repository;
import task.esw.vantibolli.maps.SupplyOrder;
import task.esw.vantibolli.endpiont.dao.SupplyOrderDAO;
import task.esw.vantibolli.validators.SupplyOrderValidator;

/**
 *
 * @author Ali Imran
 */
@Repository
public class SupplyOrderDAOImpl extends AbstractDao<Long, SupplyOrder> implements SupplyOrderDAO {

    /**
     *
     */
    public SupplyOrderDAOImpl() {
        super(new SupplyOrderValidator());
    }
}
