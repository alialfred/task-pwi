/*
 * Copyright (C) 2017 Ali Imran, All Rights Reserved.
 */
package task.esw.vantibolli.endpiont.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task.esw.vantibolli.endpiont.dao.PurchaseDAO;
import task.esw.vantibolli.endpiont.services.PurchaseService;
import task.esw.vantibolli.maps.Purchase;

/**
 *
 * @author Ali Imran
 */
@Service
public class PurchaseServiceImpl extends AbstractService<Long, Purchase> implements PurchaseService {

    /**
     *
     * @param dao
     */
    @Autowired
    public PurchaseServiceImpl(PurchaseDAO dao) {
        super(dao);
    }
}
