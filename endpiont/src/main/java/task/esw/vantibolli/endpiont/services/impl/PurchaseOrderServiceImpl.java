/*
 * Copyright (C) 2017 Ali Imran, All Rights Reserved.
 */
package task.esw.vantibolli.endpiont.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task.esw.vantibolli.endpiont.dao.PurchaseOrderDAO;
import task.esw.vantibolli.endpiont.services.PurchaseOrderService;
import task.esw.vantibolli.maps.PurchaseOrder;

/**
 *
 * @author Ali Imran
 */
@Service
public class PurchaseOrderServiceImpl extends AbstractService<Long, PurchaseOrder> implements PurchaseOrderService {

    /**
     *
     * @param dao
     */
    @Autowired
    public PurchaseOrderServiceImpl(PurchaseOrderDAO dao) {
        super(dao);
    }
}
