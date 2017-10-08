/*
 * Copyright (C) 2017 Ali Imran, All Rights Reserved.
 */
package task.esw.vantibolli.endpiont.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task.esw.vantibolli.endpiont.dao.LocationDAO;
import task.esw.vantibolli.endpiont.services.LocationService;
import task.esw.vantibolli.maps.Location;

/**
 *
 * @author Ali Imran
 */
@Service
public class LocationServiceImpl extends AbstractService<Long, Location> implements LocationService {

    /**
     *
     * @param dao
     */
    @Autowired
    public LocationServiceImpl(LocationDAO dao) {
        super(dao);
    }
}
