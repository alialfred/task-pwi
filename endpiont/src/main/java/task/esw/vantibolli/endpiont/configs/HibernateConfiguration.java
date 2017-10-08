/*
 * Copyright (C) 2017 Ali Imran, All Rights Reserved.
 */
package task.esw.vantibolli.endpiont.configs;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import task.esw.vantibolli.maps.Brand;
import task.esw.vantibolli.maps.Location;
import task.esw.vantibolli.maps.Product;
import task.esw.vantibolli.maps.ProductVariation;
import task.esw.vantibolli.maps.Purchase;
import task.esw.vantibolli.maps.PurchaseDet;
import task.esw.vantibolli.maps.PurchaseOrder;
import task.esw.vantibolli.maps.PurchaseOrderDet;
import task.esw.vantibolli.maps.Supply;
import task.esw.vantibolli.maps.SupplyDet;
import task.esw.vantibolli.maps.SupplyOrder;
import task.esw.vantibolli.maps.SupplyOrderDet;
import task.esw.vantibolli.maps.Warehouse;
import task.esw.vantibolli.maps.WarehouseOpening;
import task.esw.vantibolli.maps.WarehouseOpeningDet;
import task.esw.vantibolli.maps.WarehouseVariation;
import task.esw.vantibolli.maps.WarehouseVariationDet;

/**
 * Configuration Class for Hibernate 
 *
 * @author Ali Imran
 */
@Profile({"production", "default"})
@Configuration
@EnableTransactionManagement
@ComponentScan({"task.esw.vantibolli.endpiont"})
public class HibernateConfiguration {

    @Autowired
    private Environment environment;

    /**
     * Configure and add Entity Classes to SessionFactory
     *
     * @return SessionFactory
     */
    @Bean
    public SessionFactory sessionFactory() {
        LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource());
        sessionBuilder.addProperties(hibernateProperties());
        sessionBuilder.addAnnotatedClass(Brand.class);
        sessionBuilder.addAnnotatedClass(Location.class);
        sessionBuilder.addAnnotatedClass(Product.class);
        sessionBuilder.addAnnotatedClass(ProductVariation.class);
        sessionBuilder.addAnnotatedClass(Purchase.class);
        sessionBuilder.addAnnotatedClass(PurchaseDet.class);
        sessionBuilder.addAnnotatedClass(PurchaseOrder.class);
        sessionBuilder.addAnnotatedClass(PurchaseOrderDet.class);
        sessionBuilder.addAnnotatedClass(Supply.class);
        sessionBuilder.addAnnotatedClass(SupplyDet.class);
        sessionBuilder.addAnnotatedClass(SupplyOrder.class);
        sessionBuilder.addAnnotatedClass(SupplyOrderDet.class);
        sessionBuilder.addAnnotatedClass(Warehouse.class);
        sessionBuilder.addAnnotatedClass(WarehouseOpening.class);
        sessionBuilder.addAnnotatedClass(WarehouseOpeningDet.class);
        sessionBuilder.addAnnotatedClass(WarehouseVariation.class);
        sessionBuilder.addAnnotatedClass(WarehouseVariationDet.class);

        return sessionBuilder.buildSessionFactory();
    }

    /**
     * Configure Data Source for Hibernate
     *
     * @return DataSource
     */
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
        return dataSource;
    }

    /**
     * Configure Properties for Hibernate
     *
     * @return Properties
     */
    public Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
        return properties;
    }

    /**
     * Configure TransactionManager for @param sessionFactory
     *
     * @param sessionFactory
     * @return HibernateTransactionManager
     */
    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);
        return txManager;
    }
}
