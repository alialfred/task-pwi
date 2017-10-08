/*
 * Copyright (C) 2017 Ali Imran, All Rights Reserved.
 */
package task.esw.vantibolli.endpiont.configs;

import java.util.Properties;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/*
 */
/**
 * This class is same as real HibernateConfiguration class in sources. Only
 * difference is that method dataSource & hibernateProperties implementations
 * are specific to Hibernate working with H2 database.
 *
 * @author Ali Imran
 */
@Profile({"test"})
@Configuration
@EnableTransactionManagement
@ComponentScan({"task.esw.vantibolli.endpiont.dao"})
public class HibernateTestConfiguration extends HibernateConfiguration {

    /**
     *
     * @return
     */
    @Bean
    @Override
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        return dataSource;
    }

    /**
     *
     * @return
     */
    @Override
    public Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.put("hibernate.hbm2ddl.auto", "create");
//        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");
        return properties;
    }

}
