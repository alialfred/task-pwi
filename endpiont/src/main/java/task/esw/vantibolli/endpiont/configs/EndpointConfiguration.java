/*
 * Copyright (C) 2017 Ali Imran, All Rights Reserved.
 */
package task.esw.vantibolli.endpiont.configs;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 *  Configuration Class for Spring Boot Endpoint
 * 
 * @author Ali Imran
 */
@Configuration
@ComponentScan(basePackages = "task.esw.vantibolli.endpiont")
public class EndpointConfiguration {

    /**
     *
     * @return MessageSource for Internationalization
     */
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }

}
