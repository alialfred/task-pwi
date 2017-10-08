/*
 * Copyright (C) 2017 Ali Imran, All Rights Reserved.
 */
package task.esw.vantibolli.endpiont.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import task.esw.vantibolli.endpiont.services.AService;
import task.esw.vantibolli.maps.Brand;

/**
 * Controller Class for Report Data Rest calls 
 *
 * @author Ali Imran
 */
@RestController
@RequestMapping(value = "/report")
public class ReportController {

    private final AService<Long, Brand> brandService;
    private final ObjectMapper objectMapper;

    /**
     *
     * @param brandService
     * @param objectMapper
     */
    @Autowired
    public ReportController(AService<Long, Brand> brandService,
            ObjectMapper objectMapper) {
        this.brandService = brandService;
        this.objectMapper = objectMapper;
    }

    /**
     *
     * @return report data
     */
    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<List<Object[]>> report() {
        try {
            List list = brandService.report();
            return new ResponseEntity(list, HttpStatus.OK);
        } catch (Exception exc) {
            throw new RuntimeException(exc.getLocalizedMessage());

        }
    }
}
