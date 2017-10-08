/*
 * Copyright (C) 2017 Ali Imran, All Rights Reserved.
 */
package task.esw.vantibolli.endpiont.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task.esw.vantibolli.maps.Supply;
import task.esw.vantibolli.endpiont.dao.SupplyDAO;
import task.esw.vantibolli.endpiont.services.SupplyService;

/**
 *
 * @author Ali Imran
 */
@Service
public class SupplyServiceImpl extends AbstractService<Long, Supply> implements SupplyService {

    /**
     *
     * @param dao
     */
    @Autowired
    public SupplyServiceImpl(SupplyDAO dao) {
        super(dao);
    }
}
