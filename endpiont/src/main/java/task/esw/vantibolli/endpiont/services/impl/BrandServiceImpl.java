/*
 * Copyright (C) 2017 Ali Imran, All Rights Reserved.
 */
package task.esw.vantibolli.endpiont.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task.esw.vantibolli.endpiont.dao.BrandDAO;
import task.esw.vantibolli.endpiont.services.BrandService;
import task.esw.vantibolli.maps.Brand;

/**
 *
 * @author Ali Imran
 */
@Service
public class BrandServiceImpl extends AbstractService<Long, Brand> implements BrandService {

    /**
     *
     * @param dao
     */
    @Autowired
    public BrandServiceImpl(BrandDAO dao) {
        super(dao);
    }
}
