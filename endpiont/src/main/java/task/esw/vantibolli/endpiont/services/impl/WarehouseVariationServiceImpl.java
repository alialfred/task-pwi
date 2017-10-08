/*
 * Copyright (C) 2017 Ali Imran, All Rights Reserved.
 */
package task.esw.vantibolli.endpiont.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task.esw.vantibolli.endpiont.dao.WarehouseVariationDAO;
import task.esw.vantibolli.endpiont.services.WarehouseVariationService;
import task.esw.vantibolli.maps.WarehouseVariation;

/**
 *
 * @author Ali Imran
 */
@Service
public class WarehouseVariationServiceImpl extends AbstractService<Long, WarehouseVariation> implements WarehouseVariationService {

    /**
     *
     * @param dao
     */
    @Autowired
    public WarehouseVariationServiceImpl(WarehouseVariationDAO dao) {
        super(dao);
    }
}
