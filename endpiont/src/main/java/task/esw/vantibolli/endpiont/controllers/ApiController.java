/*
 * Copyright (C) 2017 Ali Imran, All Rights Reserved.
 */
package task.esw.vantibolli.endpiont.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import task.esw.vantibolli.endpiont.dao.DAO;
import task.esw.vantibolli.endpiont.services.AService;
import task.esw.vantibolli.maps.Brand;
import task.esw.vantibolli.maps.Location;
import task.esw.vantibolli.maps.Product;
import task.esw.vantibolli.maps.ProductVariation;
import task.esw.vantibolli.maps.Purchase;
import task.esw.vantibolli.maps.PurchaseOrder;
import task.esw.vantibolli.maps.Supply;
import task.esw.vantibolli.maps.SupplyOrder;
import task.esw.vantibolli.maps.Warehouse;
import task.esw.vantibolli.maps.WarehouseOpening;
import task.esw.vantibolli.maps.WarehouseVariation;

/**
 * Controller Class for Rest calls 
 *
 * Note: i skip the code for throwing error of 404 (Page not found)
 * 
 * @author Ali Imran
 */
@RestController
@RequestMapping(value = "/api")
public class ApiController {

    /**
     * Collection for services classes.
     * 
     * @see AService
     * @see DAO
     */
    Map<String, AService> services = Collections.synchronizedMap(new HashMap<>());

    /**
     * Object Mapper for JSON converting 
     */
    private final ObjectMapper objectMapper;

    /**
     * Constructor for Controller and Auto wired Parameters
     *
     * @param brandService
     * @param locationService
     * @param productService
     * @param productVariationService
     * @param purchaseOrderService
     * @param purchaseService
     * @param supplyOrderService
     * @param supplyService
     * @param warehouseOpeningService
     * @param warehouseService
     * @param warehouseVariationService
     * @param objectMapper
     */
    @Autowired
    public ApiController(AService<Long, Brand> brandService,
            AService<Long, Location> locationService,
            AService<Long, Product> productService,
            AService<Long, ProductVariation> productVariationService,
            AService<Long, PurchaseOrder> purchaseOrderService,
            AService<Long, Purchase> purchaseService,
            AService<Long, SupplyOrder> supplyOrderService,
            AService<Long, Supply> supplyService,
            AService<Long, WarehouseOpening> warehouseOpeningService,
            AService<Long, Warehouse> warehouseService,
            AService<Long, WarehouseVariation> warehouseVariationService,
            ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;

        services.put("Brand", brandService);
        services.put("Location", locationService);
        services.put("Product", productService);
        services.put("ProductVariation", productVariationService);
        services.put("PurchaseOrder", purchaseOrderService);
        services.put("Purchase", purchaseService);
        services.put("SupplyOrder", supplyOrderService);
        services.put("Supply", supplyService);
        services.put("WarehouseOpening", warehouseOpeningService);
        services.put("Warehouse", warehouseService);
        services.put("WarehouseVariation", warehouseVariationService);
    }

    /**
     * Endpoint for List Calls
     *
     * @param entity a path variable to specify Entity Call
     * @return response entity with resulting Entity Collection
     */
    @ResponseBody
    @RequestMapping(value = "/{entity}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<List<Object>> getAll(@PathVariable String entity) {
        try {
            List list = services.get(entity).list();
            return new ResponseEntity(list, HttpStatus.OK);
        } catch (Exception exc) {
            throw new RuntimeException(exc.getLocalizedMessage());

        }
    }

    /**
     * Endpoint for single (unique) Entity
     *
     * @param entity a path variable of Data Entity to return
     * @param id an Identity value for Data Entity
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/{entity}/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<Object> get(@PathVariable String entity, @PathVariable Long id) {
        try {
            return new ResponseEntity(services.get(entity).getById(id), HttpStatus.OK);
        } catch (Exception exc) {
            throw new RuntimeException(exc.getLocalizedMessage());

        }
    }

    /**
     * Endpoint for POST (Create), PUT/PATCH (Update)
     *
     * @param entity in witch to create or update to
     * @param body data body to be create or update
     * @param request to figure out witch HTTP method is called
     * @return response entity with resulting Data Entity
     */
    @ResponseBody
    @RequestMapping(value = "/{entity}", method = {RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.POST}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    @SuppressWarnings("UseSpecificCatch")
    public ResponseEntity<Object> putAndPost(@PathVariable String entity, @RequestBody String body, HttpServletRequest request) {
        try {
            String method = request.getMethod();
            AService service = services.get(entity);

            Object value = objectMapper.readValue(body, service.getEntityClass());

            value = "POST".equalsIgnoreCase(method) ? service.save(value) : service.upate(value);
            HttpStatus status = "POST".equalsIgnoreCase(method) ? HttpStatus.CREATED : HttpStatus.OK;

            return new ResponseEntity(value, status);
        } catch (Exception exc) {
            exc.printStackTrace(System.err);
            throw new RuntimeException(exc.getLocalizedMessage());

        }
    }

    /**
     * Endpoint for DELETE (delete/remove) 
     *
     * @param entity to delete from
     * @param id Identity of Entity for deleting 
     * @return true is succeed, false if unable to delete
     */
    @ResponseBody
    @RequestMapping(value = "/{entity}/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable String entity, @PathVariable Long id) {
        try {
            services.get(entity).delete(id);
            return new ResponseEntity(true, HttpStatus.OK);
        } catch (Exception exc) {
            throw new RuntimeException(exc.getLocalizedMessage());

        }
    }
}
