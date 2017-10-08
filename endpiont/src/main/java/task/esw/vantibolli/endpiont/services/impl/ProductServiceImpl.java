/*
 * Copyright (C) 2017 Ali Imran, All Rights Reserved.
 */
package task.esw.vantibolli.endpiont.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task.esw.vantibolli.endpiont.dao.ProductDAO;
import task.esw.vantibolli.endpiont.services.ProductService;
import task.esw.vantibolli.maps.Product;

/**
 *
 * @author Ali Imran
 */
@Service
public class ProductServiceImpl extends AbstractService<Long, Product> implements ProductService {

    /**
     *
     * @param dao
     */
    @Autowired
    public ProductServiceImpl(ProductDAO dao) {
        super(dao);
    }
}
