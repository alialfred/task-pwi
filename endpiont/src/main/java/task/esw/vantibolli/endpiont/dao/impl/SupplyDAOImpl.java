/*
 * Copyright (C) 2017 Ali Imran, All Rights Reserved.
 */
package task.esw.vantibolli.endpiont.dao.impl;

import org.springframework.stereotype.Repository;
import task.esw.vantibolli.maps.Supply;
import task.esw.vantibolli.endpiont.dao.SupplyDAO;
import task.esw.vantibolli.validators.SupplyValidator;

/**
 *
 * @author Ali Imran
 */
@Repository
public class SupplyDAOImpl extends AbstractDao<Long, Supply> implements SupplyDAO {

    /**
     *
     */
    public SupplyDAOImpl() {
        super(new SupplyValidator());
    }

}
