/*
 * Copyright (C) 2017 Ali Imran, All Rights Reserved.
 */
package task.esw.vantibolli.endpiont.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task.esw.vantibolli.maps.SupplyOrder;
import task.esw.vantibolli.endpiont.dao.SupplyOrderDAO;
import task.esw.vantibolli.endpiont.services.SupplyOrderService;

/**
 *
 * @author Ali Imran
 */
@Service
public class SupplyOrderServiceImpl extends AbstractService<Long, SupplyOrder> implements SupplyOrderService {

    /**
     *
     * @param dao
     */
    @Autowired
    public SupplyOrderServiceImpl(SupplyOrderDAO dao) {
        super(dao);
    }
}
