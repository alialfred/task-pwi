/*
 * Copyright (C) 2017 Ali Imran, All Rights Reserved.
 */
package task.esw.vantibolli.endpiont.dao.impl;

import org.springframework.stereotype.Repository;
import task.esw.vantibolli.endpiont.dao.LocationDAO;
import task.esw.vantibolli.maps.Location;

/**
 *
 * @author Ali Imran
 */
@Repository
public class LocationDAOImpl extends AbstractDao<Long, Location> implements LocationDAO {
}
