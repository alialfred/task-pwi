#  Technical Task for Product and Warehouse and Inventory (PWI) 

## Prerequisites:
* MySQL 5.xx
* Java 1.8 
* Maven 3.*
* Development IDE Netbeans 8.2
## Project Structure 
<pre>
|   <b>nb-configuration.xml</b>  <i>Netbeans Configuration File</i>
|   <b>pom.xml</b>  <i>Parent Project pom File</i>
|
</pre>
### Client Endpoint
<pre>
\--- <b>Client end Application for demonstrate RESTful actions</b>
|   |   <b>nbactions.xml</b>  <i>Netbeans Configuration File</i>
|   |   <b>pom.xml</b>  <i>Client end pom file</i>
|   |
|   \---src
|       \---main
|           \---java
|               \---task
|                   \---esw
|                       \---vantibolli
|                           \---clientend
|                                   <b>Application.java</b>  <i>Application Startup Class with main(String[]) methods action flow.</i>
|       
</pre>
### Endpoint Service (Server)
<pre>
\--- <b>Endpiont Service</b>
|   |   <b>nbactions.xml</b>  <i>Netbeans Configuration File</i>
|   |   <b>pom.xml</b>  <i>Endpoint pom File</i>
|   |
|   \---src
|       \---main
|       |   \---java
|       |   |   \---task
|       |   |       \---esw
|       |   |           \---vantibolli
|       |   |               \---endpiont
|       |   |                   |   <b>Main.java</b>  <i>Application Startup Class with main(String[]) method for <i>
|       |   |                   |
|       |   |                   \---configs
|       |   |                   |       <b>EndpointConfiguration.java</b>  <i>Endpoint Configurations</i>
|       |   |                   |       <b>HibernateConfiguration.java</b>  <i>Hibernate Configurations</i>
|       |   |                   |
|       |   |                   \---controllers
|       |   |                   |       <b>ApiController.java</b>  <i>Application Program Interface  Controller (Responsible for RESTful Class as <b>GET,POST,PUT/PATCH,DELETE</b></i>
|       |   |                   |       <b>ReportController.java</b>  <i>Controller for Reporting Calls</i>
|       |   |                   |
|       |   |                   \---dao
|       |   |                   |   |   BrandDAO.java
|       |   |                   |   |   <b>DAO.java</b>  <i>Database logics Interface Class</b>
|       |   |                   |   |   LocationDAO.java
|       |   |                   |   |   ProductDAO.java
|       |   |                   |   |   ProductVariationDAO.java
|       |   |                   |   |   PurchaseDAO.java
|       |   |                   |   |   PurchaseOrderDAO.java
|       |   |                   |   |   SupplyDAO.java
|       |   |                   |   |   SupplyOrderDAO.java
|       |   |                   |   |   WarehouseDAO.java
|       |   |                   |   |   WarehouseOpeningDAO.java
|       |   |                   |   |   WarehouseVariationDAO.java
|       |   |                   |   |
|       |   |                   |   \---impl
|       |   |                   |           <b>AbstractDao.java</b>  <i>Database logics Implemented Class</b>
|       |   |                   |           BrandDAOImpl.java
|       |   |                   |           LocationDAOImpl.java
|       |   |                   |           ProductDAOImpl.java
|       |   |                   |           ProductVariationDAOImpl.java
|       |   |                   |           PurchaseDAOImpl.java
|       |   |                   |           PurchaseOrderDAOImpl.java
|       |   |                   |           SupplyDAOImpl.java
|       |   |                   |           SupplyOrderDAOImpl.java
|       |   |                   |           WarehouseDAOImpl.java
|       |   |                   |           WarehouseOpeningDAOImpl.java
|       |   |                   |           WarehouseVariationDAOImpl.java
|       |   |                   |
|       |   |                   \---services
|       |   |                       |   <b>AService.java</b>  <i>Abstract Service Interface Class (See DAO)</i>
|       |   |                       |   BrandService.java
|       |   |                       |   LocationService.java
|       |   |                       |   ProductService.java
|       |   |                       |   ProductVariationService.java
|       |   |                       |   PurchaseOrderService.java
|       |   |                       |   PurchaseService.java
|       |   |                       |   SupplyOrderService.java
|       |   |                       |   SupplyService.java
|       |   |                       |   WarehouseOpeningService.java
|       |   |                       |   WarehouseService.java
|       |   |                       |   WarehouseVariationService.java
|       |   |                       |
|       |   |                       \---impl
|       |   |                               <b>AbstractService.java</b>  <i>Abstract Service Interface Class (AbstractDao)</b>
|       |   |                               BrandServiceImpl.java
|       |   |                               LocationServiceImpl.java
|       |   |                               ProductServiceImpl.java
|       |   |                               ProductVariationServiceImpl.java
|       |   |                               PurchaseOrderServiceImpl.java
|       |   |                               PurchaseServiceImpl.java
|       |   |                               SupplyOrderServiceImpl.java
|       |   |                               SupplyServiceImpl.java
|       |   |                               WarehouseOpeningServiceImpl.java
|       |   |                               WarehouseServiceImpl.java
|       |   |                               WarehouseVariationServiceImpl.java
|       |   |
|       |   \---resources
|       |       |   <b>application.properties</b>  <i>Application's Property file for Spring Boot and Hibernate etc.</i>
|       |       |   application.test.properties
|       |       |   messages.properties
|       |       |   <b>report.sql</b>  <i>SQL Query for fetching report data from Database</i>  
|       |       |
|       |       \---static
|       \---test
|           \---java
|           |   \---task
|           |       \---esw
|           |           \---vantibolli
|           |               \---endpiont
|           |                   \---configs
|           |                   |       <b>HibernateTestConfiguration.java</b>  <i>Hibernate Configurations for Build Tests </i>
|           |                   |
|           |                   \---controller
|           |                           <b>ApiControllerTest.java</b>  <i>Integrated Test Class for also show work-flow of client end</i>
|           |
|           \---resources
</pre>
### Project Mapping Classes (POJOs/Data Entities)
<pre>
\---maps
    |   pom.xml
    |
    \---src
        \---main
        |   \---java
        |   |   \---task
        |   |       \---esw
        |   |           \---vantibolli
        |   |               \---maps
        |   |               |       Brand.java
        |   |               |       Location.java
        |   |               |       Product.java
        |   |               |       ProductType.java
        |   |               |       ProductVariation.java
        |   |               |       Purchase.java
        |   |               |       PurchaseDet.java
        |   |               |       PurchaseOrder.java
        |   |               |       PurchaseOrderDet.java
        |   |               |       Supply.java
        |   |               |       SupplyDet.java
        |   |               |       SupplyOrder.java
        |   |               |       SupplyOrderDet.java
        |   |               |       Warehouse.java
        |   |               |       WarehouseOpening.java
        |   |               |       WarehouseOpeningDet.java
        |   |               |       WarehouseVariation.java
        |   |               |       WarehouseVariationDet.java
        |   |               |
        |   |               \---validators
        |   |                       DataValidator.java
        |   |                       SupplyOrderValidator.java
        |   |                       SupplyValidator.java
        |   |
        |   \---resources
        \---test
            \---java
                \---task
                    \---esw
                        \---vantibolli
                            \---test
                                \---maps
                                        BrandTest.java
</pre>
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

