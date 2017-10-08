#  Technical Task for Product and Warehouse and Inventory (PWI) 

## Prerequisites:
* MySQL 5.xx
* Java 1.8 
* Maven 3.*
* Development IDE Netbeans 8.2

## Project Structure 
?   `nb-configuration.xml`  Netbeans Configuration File
?   `pom.xml`  Parent Project pom File
?
### Client Endpoint
???? Client end Application for demonstrate RESTful actions
?   ?   `nbactions.xml`  Netbeans Configuration File
?   ?   `pom.xml`    Client end pom file
?   ?
?   ????src
?       ????main
?           ????java
?               ????task
?                   ????esw
?                       ????vantibolli
?                           ????clientend
?                                   `Application.java`  Application Startup Class with main(String[]) methods action flow.
?       
### Endpoint Service (Server)
???? Endpiont Service 
?   ?   `nbactions.xml`  Netbeans Configuration File
?   ?   `pom.xml`   Endpoint pom File
?   ?
?   ????src
?       ????main
?       ?   ????java
?       ?   ?   ????task
?       ?   ?       ????esw
?       ?   ?           ????vantibolli
?       ?   ?               ????endpiont
?       ?   ?                   ?   `Main.java`   Application Startup Class with main(String[]) method for 
?       ?   ?                   ?
?       ?   ?                   ????configs
?       ?   ?                   ?       `EndpointConfiguration.java`   Endpoint Configurations
?       ?   ?                   ?       `HibernateConfiguration.java`  Hibernate Configurations
?       ?   ?                   ?
?       ?   ?                   ????controllers
?       ?   ?                   ?       `ApiController.java`  Application Program Interface  Controller (Responsible for RESTful Class as GET,POST,PUT/PATCH,DELETE
?       ?   ?                   ?       'ReportController.java'  Controller for Reporting Calls
?       ?   ?                   ?
?       ?   ?                   ????dao
?       ?   ?                   ?   ?   BrandDAO.java
?       ?   ?                   ?   ?   `DAO.java`  Database logics Interface Class
?       ?   ?                   ?   ?   LocationDAO.java
?       ?   ?                   ?   ?   ProductDAO.java
?       ?   ?                   ?   ?   ProductVariationDAO.java
?       ?   ?                   ?   ?   PurchaseDAO.java
?       ?   ?                   ?   ?   PurchaseOrderDAO.java
?       ?   ?                   ?   ?   SupplyDAO.java
?       ?   ?                   ?   ?   SupplyOrderDAO.java
?       ?   ?                   ?   ?   WarehouseDAO.java
?       ?   ?                   ?   ?   WarehouseOpeningDAO.java
?       ?   ?                   ?   ?   WarehouseVariationDAO.java
?       ?   ?                   ?   ?
?       ?   ?                   ?   ????impl
?       ?   ?                   ?           `AbstractDao.java`  Database logics Implemented Class
?       ?   ?                   ?           BrandDAOImpl.java
?       ?   ?                   ?           LocationDAOImpl.java
?       ?   ?                   ?           ProductDAOImpl.java
?       ?   ?                   ?           ProductVariationDAOImpl.java
?       ?   ?                   ?           PurchaseDAOImpl.java
?       ?   ?                   ?           PurchaseOrderDAOImpl.java
?       ?   ?                   ?           SupplyDAOImpl.java
?       ?   ?                   ?           SupplyOrderDAOImpl.java
?       ?   ?                   ?           WarehouseDAOImpl.java
?       ?   ?                   ?           WarehouseOpeningDAOImpl.java
?       ?   ?                   ?           WarehouseVariationDAOImpl.java
?       ?   ?                   ?
?       ?   ?                   ????services
?       ?   ?                       ?   `AService.java`  Abstract Service Interface Class (See DAO)
?       ?   ?                       ?   BrandService.java
?       ?   ?                       ?   LocationService.java
?       ?   ?                       ?   ProductService.java
?       ?   ?                       ?   ProductVariationService.java
?       ?   ?                       ?   PurchaseOrderService.java
?       ?   ?                       ?   PurchaseService.java
?       ?   ?                       ?   SupplyOrderService.java
?       ?   ?                       ?   SupplyService.java
?       ?   ?                       ?   WarehouseOpeningService.java
?       ?   ?                       ?   WarehouseService.java
?       ?   ?                       ?   WarehouseVariationService.java
?       ?   ?                       ?
?       ?   ?                       ????impl
?       ?   ?                               `AbstractService.java`  Abstract Service Interface Class (AbstractDao)
?       ?   ?                               BrandServiceImpl.java
?       ?   ?                               LocationServiceImpl.java
?       ?   ?                               ProductServiceImpl.java
?       ?   ?                               ProductVariationServiceImpl.java
?       ?   ?                               PurchaseOrderServiceImpl.java
?       ?   ?                               PurchaseServiceImpl.java
?       ?   ?                               SupplyOrderServiceImpl.java
?       ?   ?                               SupplyServiceImpl.java
?       ?   ?                               WarehouseOpeningServiceImpl.java
?       ?   ?                               WarehouseServiceImpl.java
?       ?   ?                               WarehouseVariationServiceImpl.java
?       ?   ?
?       ?   ????resources
?       ?       ?   `application.properties`  Application's Property file for Spring Boot and Hibernate etc.
?       ?       ?   application.test.properties
?       ?       ?   messages.properties
?       ?       ?   `report.sql`  SQL Query for fetching report data from Database  
?       ?       ?
?       ?       ????static
?       ????test
?           ????java
?           ?   ????task
?           ?       ????esw
?           ?           ????vantibolli
?           ?               ????endpiont
?           ?                   ????configs
?           ?                   ?       `HibernateTestConfiguration.java`  Hibernate Configurations for Build Tests 
?           ?                   ?
?           ?                   ????controller
?           ?                           `ApiControllerTest.java`  Integrated Test Class for also show work-flow of client end
?           ?
?           ????resources
### Project Mapping Classes (POJOs/Data Entities)
????maps
    ?   pom.xml
    ?
    ????src
        ????main
        ?   ????java
        ?   ?   ????task
        ?   ?       ????esw
        ?   ?           ????vantibolli
        ?   ?               ????maps
        ?   ?               ?       Brand.java
        ?   ?               ?       Location.java
        ?   ?               ?       Product.java
        ?   ?               ?       ProductType.java
        ?   ?               ?       ProductVariation.java
        ?   ?               ?       Purchase.java
        ?   ?               ?       PurchaseDet.java
        ?   ?               ?       PurchaseOrder.java
        ?   ?               ?       PurchaseOrderDet.java
        ?   ?               ?       Supply.java
        ?   ?               ?       SupplyDet.java
        ?   ?               ?       SupplyOrder.java
        ?   ?               ?       SupplyOrderDet.java
        ?   ?               ?       Warehouse.java
        ?   ?               ?       WarehouseOpening.java
        ?   ?               ?       WarehouseOpeningDet.java
        ?   ?               ?       WarehouseVariation.java
        ?   ?               ?       WarehouseVariationDet.java
        ?   ?               ?
        ?   ?               ????validators
        ?   ?                       DataValidator.java
        ?   ?                       SupplyOrderValidator.java
        ?   ?                       SupplyValidator.java
        ?   ?
        ?   ????resources
        ????test
            ????java
                ????task
                    ????esw
                        ????vantibolli
                            ????test
                                ????maps
                                        BrandTest.java

## Project Instruction
1. Download/Clone the project 
2. Open `Parent Project` in Netbeans 8.2
3. Prepare the database
  * create database `esw_vantibolli` in MySQL or change database connection url in -  [endpoint/src/main/resources/application.properties]  (https://github.com/alialfred/task-pwi/blob/master/endpiont/src/main/resources/application.properties)
  * username/password - `root`/`` or change the values in above mentioned property file
> **Note:** no password is set for MySQL Database connection
4. Run `endpoint` project in Netbeans 8.2 
  * select project `endpoint` then press `F6` key or by clicking menu: `Run->Run Project`
  * now the REST api is up and running at `localhost:8080`   
5. Run `clientend` project in Netbeans 8.2
  * repeat above process on `clientend` project.
> **Note:** if everything goes right, output will be shows on Netbeans output (console) window 
	   

## Testing the project 

### From Netbeans 8.2
1. Execute Build command on project `endpoint` in Netbeans 8.2 by pressing `F11` key or by clicking menu: `Run->Build Project`
  * testing output will be displayed on Netbeans output (console) window.
> **Note:** if you want to test on `Production` profile, simply comment-out or remove the line `#61: System.setProperty("spring.profiles.active", "test");`

