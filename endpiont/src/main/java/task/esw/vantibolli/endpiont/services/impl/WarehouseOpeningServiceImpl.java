/*
 * Copyright (C) 2017 Ali Imran, All Rights Reserved.
 */
package task.esw.vantibolli.endpiont.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task.esw.vantibolli.endpiont.dao.WarehouseOpeningDAO;
import task.esw.vantibolli.endpiont.services.WarehouseOpeningService;
import task.esw.vantibolli.maps.WarehouseOpening;

/**
 *
 * @author Ali Imran
 */
@Service
public class WarehouseOpeningServiceImpl extends AbstractService<Long, WarehouseOpening> implements WarehouseOpeningService {

    /**
     *
     * @param dao
     */
    @Autowired
    public WarehouseOpeningServiceImpl(WarehouseOpeningDAO dao) {
        super(dao);
    }
}
