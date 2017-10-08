/*
 * Copyright (C) 2017 Ali Imran, All Rights Reserved.
 */
package task.esw.vantibolli.endpiont;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

/**
 * Spring boot Main Application
 *
 * @author Ali Imran
 */
@PropertySource(value = {"classpath:application.properties"})
@SpringBootApplication
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Main.class, args);
    }

}
