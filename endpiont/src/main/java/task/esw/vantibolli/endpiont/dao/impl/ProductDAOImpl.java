/*
 * Copyright (C) 2017 Ali Imran, All Rights Reserved.
 */
package task.esw.vantibolli.endpiont.dao.impl;

import org.springframework.stereotype.Repository;
import task.esw.vantibolli.endpiont.dao.ProductDAO;
import task.esw.vantibolli.maps.Product;

/**
 *
 * @author Ali Imran
 */
@Repository
public class ProductDAOImpl extends AbstractDao<Long, Product> implements ProductDAO {
}
