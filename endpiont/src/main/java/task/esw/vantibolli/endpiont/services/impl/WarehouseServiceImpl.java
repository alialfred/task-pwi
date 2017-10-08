/*
 * Copyright (C) 2017 Ali Imran, All Rights Reserved.
 */
package task.esw.vantibolli.endpiont.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task.esw.vantibolli.endpiont.dao.WarehouseDAO;
import task.esw.vantibolli.endpiont.services.WarehouseService;
import task.esw.vantibolli.maps.Warehouse;

/**
 *
 * @author Ali Imran
 */
@Service
public class WarehouseServiceImpl extends AbstractService<Long, Warehouse> implements WarehouseService {

    /**
     *
     * @param dao
     */
    @Autowired
    public WarehouseServiceImpl(WarehouseDAO dao) {
        super(dao);
    }
}
