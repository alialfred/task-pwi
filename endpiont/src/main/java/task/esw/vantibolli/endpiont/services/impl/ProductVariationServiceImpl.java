/*
 * Copyright (C) 2017 Ali Imran, All Rights Reserved.
 */
package task.esw.vantibolli.endpiont.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task.esw.vantibolli.endpiont.dao.ProductVariationDAO;
import task.esw.vantibolli.endpiont.services.ProductVariationService;
import task.esw.vantibolli.maps.ProductVariation;

/**
 *
 * @author Ali Imran
 */
@Service
public class ProductVariationServiceImpl extends AbstractService<Long, ProductVariation> implements ProductVariationService {

    /**
     *
     * @param dao
     */
    @Autowired
    public ProductVariationServiceImpl(ProductVariationDAO dao) {
        super(dao);
    }
}
