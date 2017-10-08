/*
 * Copyright (C) 2017 Ali Imran, All Rights Reserved.
 */
package task.esw.vantibolli.endpiont.controller;

import java.net.URI;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import task.esw.vantibolli.maps.Brand;
import task.esw.vantibolli.maps.BrandAssert;
import task.esw.vantibolli.maps.Location;
import task.esw.vantibolli.maps.LocationAssert;
import task.esw.vantibolli.maps.Product;
import task.esw.vantibolli.maps.ProductAssert;
import task.esw.vantibolli.maps.ProductType;
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
import task.esw.vantibolli.maps.WarehouseAssert;
import task.esw.vantibolli.maps.WarehouseOpening;
import task.esw.vantibolli.maps.WarehouseOpeningDet;
import task.esw.vantibolli.maps.WarehouseVariation;
import task.esw.vantibolli.maps.WarehouseVariationDet;

/**
 * Integrated Testing Class for Api Controller
 *
 * @author Ali Imran
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext
public class ApiControllerTest extends AbstractTestNGSpringContextTests {

    private static final String API = "/api/";

    @Autowired
    private TestRestTemplate template;

    @BeforeSuite
    void setProfile() {
        System.setProperty("spring.profiles.active", "test");
        System.setProperty("hibernate.show_sql", "false");
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Test for Brand Entity (Creating New, Updating, Deleting) Eventually it
     * applies for every Entities
     *
     * @throws java.lang.Exception
     */
    //<editor-fold defaultstate="collapsed" desc="Brand Testing">
    @Test
    public void testBrand() throws Exception {
        /**
         * Testing Table is Blank
         */
        ResponseEntity<Brand> entity = this.template.getForEntity("/api/Brand/1", Brand.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        BrandAssert.assertThat(entity.getBody()).isNull();

        /**
         * Creating New
         */
        entity = this.template.postForEntity("/api/Brand/", new Brand("Brand1"), Brand.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        BrandAssert.assertThat(entity.getBody()).isNotNull().hasId(1l).hasTitle("Brand1");

        /**
         * Updating
         */
        RequestEntity<Brand> rq = new RequestEntity<>(new Brand(1l, "Brand3"), HttpMethod.PUT, new URI("/api/Brand/"));
        entity = this.template.exchange(rq, Brand.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        BrandAssert.assertThat(entity.getBody()).isNotNull().hasId(1l).hasTitle("Brand3");

        /**
         * Deleting (Short version) this.restTemplate.delete("/api/Brand/1");
         */
        RequestEntity<Boolean> delRq = new RequestEntity<>(true, HttpMethod.DELETE, new URI("/api/Brand/1"));
        ResponseEntity<Boolean> delRes = this.template.exchange(delRq, Boolean.class);
        assertThat(delRes.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(delRes.getBody()).isNotNull().isEqualTo(true);

        /**
         * Testing Again
         */
        entity = this.template.getForEntity("/api/Brand/1", Brand.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        BrandAssert.assertThat(entity.getBody()).isNull();
    }
    //</editor-fold>

    /**
     * Variables for Work-flow and Testings...
     */
    private Location USA;
    private Location Ireland;
    private Warehouse warehouse1;
    private Warehouse warehouse2;
    private Warehouse warehouse3;
    private Warehouse warehouse4;
    private Warehouse warehouse5;
    private Product product;

    /**
     *
     * @throws Exception
     */
    @Test
    public void test() throws Exception {

        USA = createLocation(1, "USA");
        LocationAssert.assertThat(USA).isNotNull().hasId(1l);
        logger.info("Location: " + USA.toString());

        Ireland = createLocation(2, "Ireland");
        LocationAssert.assertThat(Ireland).isNotNull().hasId(2l);
        logger.info("Location: " + Ireland.toString());

        warehouse1 = createWarehouse(USA, 1, "Warehouse");
        WarehouseAssert.assertThat(warehouse1).isNotNull().hasId(1l).hasLocation(USA);
        logger.info("Warehouse: " + warehouse1.toString());

        warehouse2 = createWarehouse(USA, 2, "Warehouse");
        WarehouseAssert.assertThat(warehouse2).isNotNull().hasId(2l).hasLocation(USA);
        logger.info("Warehouse: " + warehouse2.toString());

        warehouse3 = createWarehouse(USA, 3, "Warehouse");
        WarehouseAssert.assertThat(warehouse3).isNotNull().hasId(3l).hasLocation(USA);
        logger.info("Warehouse: " + warehouse3.toString());

        warehouse4 = createWarehouse(Ireland, 4, "Warehouse");
        WarehouseAssert.assertThat(warehouse4).isNotNull().hasId(4l).hasLocation(Ireland);
        logger.info("Warehouse: " + warehouse4.toString());

        warehouse5 = createWarehouse(Ireland, 5, "Warehouse");
        WarehouseAssert.assertThat(warehouse5).isNotNull().hasId(5l).hasLocation(Ireland);
        logger.info("Warehouse: " + warehouse5.toString());

        product = createProduct(1, "Product", ProductType.FINISHED_PRODUCT, "10 ml", "20 ml", "30 ml");
        ProductAssert.assertThat(product).isNotNull().hasId(1l).hasProductType(ProductType.FINISHED_PRODUCT);
        logger.info("Product: " + product.toString());

        /**
         * Just an example of Component Type
         */
        Product component = createProduct(2, "Component", ProductType.COMPONENT, "Small", "Large");
        ProductAssert.assertThat(component).isNotNull().hasId(2l).hasProductType(ProductType.COMPONENT);
        logger.info("Product: " + component.toString());

        logger.info("Creating Warehouse Variations...");
        createWarehouseVariation();
        logger.info("Warehouse Variations Created...");

        logger.info("Creating Warehouse Openings...");
        createWarehouseOpenings();
        logger.info("Warehouse Openings Created...");

        /* Uncomment for report effects*/
        //report();
        
        logger.info("Creating Purchase Order...");
        createPurchaseOrder(0);
        logger.info("Purchase Order Created...");

        /* Uncomment for report effects*/
        //report();

        logger.info("Creating Purchases...");
        createPurchase();
        logger.info("Purchases Created...");

        /* Uncomment for report effects*/
        //report();

        logger.info("Creating Purchase Order Again...");
        createPurchaseOrder(5);
        logger.info("Purchase Order Again Created...");

        /* Uncomment for report effects*/
        //report();

        logger.info("Creating Supply Order...");
        createSupplyOrder(0);
        logger.info("Supply Order Created...");

        /* Uncomment for report effects*/
        //report();

        logger.info("Creating Supply...");
        createSupply();
        logger.info("Supply Created...");

        /* Uncomment for report effects*/
        //report();

        logger.info("Creating Supply Order Again...");
        createSupplyOrder(5);
        logger.info("Supply Order Again Created...");

        report();
    }

    //<editor-fold defaultstate="collapsed" desc="Location">
    private Location createLocation(int id, String title) throws Exception {
        String url = API.concat("Location/");
        Location location = template.getForEntity(url.concat("" + id), Location.class).getBody();
        if (location == null) {
            location = new Location();
            location.setTitle(title);
            location = template.postForEntity(url, location, Location.class).getBody();
        }
        return location;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Warehouse">
    private Warehouse createWarehouse(Location location, int id, String title) throws Exception {
        String url = API.concat("Warehouse/");
        Warehouse warehouse = template.getForEntity(url.concat("" + id), Warehouse.class).getBody();
        if (warehouse == null) {
            warehouse = new Warehouse();
            warehouse.setLocation(location);
            warehouse.setTitle(title + id);
            warehouse = template.postForEntity(url, warehouse, Warehouse.class).getBody();
        }
        return warehouse;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Product">
    private Product createProduct(int id, String title, ProductType type, String... variations) throws Exception {
        String url = API.concat("Product/");
        Product product = template.getForEntity(url.concat("" + id), Product.class).getBody();
        if (product == null) {
            product = new Product();
            product.setTitle(title + id);
            product.setProductType(type);
            for (String var : variations) {
                ProductVariation pv = new ProductVariation();
                pv.setProduct(product);
                pv.setTitle(var);
                product.getVariations().add(pv);
            }
            product = template.postForEntity(url, product, Product.class).getBody();
        }
        return product;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Warehouse Variation">
    private void createWarehouseVariation() throws Exception {
        String url = API.concat("WarehouseVariation/");
        WarehouseVariation variation = template.getForEntity(url.concat("" + 1), WarehouseVariation.class).getBody();
        if (variation == null) {
            createWarehouse1Variation(url);
        }
        variation = template.getForEntity(url.concat("" + 2), WarehouseVariation.class).getBody();
        if (variation == null) {
            createWarehouse2Variation(url);
        }
        variation = template.getForEntity(url.concat("" + 3), WarehouseVariation.class).getBody();
        if (variation == null) {
            createWarehouse3Variation(url);
        }
        variation = template.getForEntity(url.concat("" + 4), WarehouseVariation.class).getBody();
        if (variation == null) {
            createWarehouse4Variation(url);
        }
        variation = template.getForEntity(url.concat("" + 5), WarehouseVariation.class).getBody();
        if (variation == null) {
            createWarehouse5Variation(url);
        }
    }

    private void createWarehouse1Variation(String url) {
        WarehouseVariation variation = new WarehouseVariation();
        variation.setWarehouse(warehouse1);
        WarehouseVariationDet det = new WarehouseVariationDet();
        det.setProduct(product);
        det.setVariation(product.getVariations().get(0));
        // As Describe in Technical Assignment
        det.setMoq(50);
        det.setQpb(6);
        det.setRop(15);
        variation.getDetailList().add(det);

        variation = template.postForEntity(url, variation, WarehouseVariation.class).getBody();
    }

    private void createWarehouse2Variation(String url) {
        WarehouseVariation variation = new WarehouseVariation();
        variation.setWarehouse(warehouse2);
        WarehouseVariationDet det = new WarehouseVariationDet();
        det.setProduct(product);
        det.setVariation(product.getVariations().get(1));
        // As Describe in Technical Assignment
        det.setMoq(1000);
        det.setQpb(12);
        det.setRop(100);
        variation.getDetailList().add(det);

        det = new WarehouseVariationDet();
        det.setProduct(product);
        det.setVariation(product.getVariations().get(2));
        // As Describe in Technical Assignment
        det.setMoq(34);
        det.setQpb(43);
        det.setRop(9);
        variation.getDetailList().add(det);

        variation = template.postForEntity(url, variation, WarehouseVariation.class).getBody();
    }

    private void createWarehouse3Variation(String url) {
        WarehouseVariation variation = new WarehouseVariation();
        variation.setWarehouse(warehouse3);
        WarehouseVariationDet det = new WarehouseVariationDet();
        det.setProduct(product);
        det.setVariation(product.getVariations().get(0));
        // As Describe in Technical Assignment
        det.setMoq(45);
        det.setQpb(50);
        det.setRop(100);
        variation.getDetailList().add(det);

        det = new WarehouseVariationDet();
        det.setProduct(product);
        det.setVariation(product.getVariations().get(2));
        // As Describe in Technical Assignment
        det.setMoq(50);
        det.setQpb(36);
        det.setRop(45);
        variation.getDetailList().add(det);

        variation = template.postForEntity(url, variation, WarehouseVariation.class).getBody();
    }

    private void createWarehouse4Variation(String url) {
        WarehouseVariation variation = new WarehouseVariation();
        variation.setWarehouse(warehouse4);
        WarehouseVariationDet det = new WarehouseVariationDet();
        det.setProduct(product);
        det.setVariation(product.getVariations().get(0));
        // As Describe in Technical Assignment
        det.setMoq(1);
        det.setQpb(4);
        det.setRop(6);
        variation.getDetailList().add(det);

        det = new WarehouseVariationDet();
        det.setProduct(product);
        det.setVariation(product.getVariations().get(2));
        // As Describe in Technical Assignment
        det.setMoq(5);
        det.setQpb(36);
        det.setRop(10);
        variation.getDetailList().add(det);

        variation = template.postForEntity(url, variation, WarehouseVariation.class).getBody();
    }

    private void createWarehouse5Variation(String url) {
        WarehouseVariation variation = new WarehouseVariation();
        variation.setWarehouse(warehouse5);
        WarehouseVariationDet det = new WarehouseVariationDet();
        det.setProduct(product);
        det.setVariation(product.getVariations().get(0));
        // As Describe in Technical Assignment
        det.setMoq(10);
        det.setQpb(8);
        det.setRop(10);
        variation.getDetailList().add(det);

        variation = template.postForEntity(url, variation, WarehouseVariation.class).getBody();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Warehouse Openings">
    private void createWarehouseOpenings() {
        String url = API.concat("WarehouseOpening/");

        WarehouseOpening opening;
        WarehouseOpeningDet det;

        if (template.getForEntity(url.concat("" + 1), WarehouseOpening.class).getBody() == null) {
            opening = new WarehouseOpening();
            opening.setWarehouse(warehouse1);
            det = new WarehouseOpeningDet();
            det.setProduct(product);
            det.setVariation(product.getVariations().get(0));
            det.setQty(10);
            opening.getDetailList().add(det);

            template.postForEntity(url, opening, WarehouseOpening.class).getBody();
        }

        if (template.getForEntity(url.concat("" + 2), WarehouseOpening.class).getBody() == null) {
            opening = new WarehouseOpening();
            opening.setWarehouse(warehouse2);
            det = new WarehouseOpeningDet();
            det.setProduct(product);
            det.setVariation(product.getVariations().get(1));
            det.setQty(900);
            opening.getDetailList().add(det);
            det = new WarehouseOpeningDet();
            det.setProduct(product);
            det.setVariation(product.getVariations().get(2));
            det.setQty(40);
            opening.getDetailList().add(det);
            template.postForEntity(url, opening, WarehouseOpening.class).getBody();
        }

        if (template.getForEntity(url.concat("" + 3), WarehouseOpening.class).getBody() == null) {
            opening = new WarehouseOpening();
            opening.setWarehouse(warehouse3);
            det = new WarehouseOpeningDet();
            det.setProduct(product);
            det.setVariation(product.getVariations().get(0));
            det.setQty(100);
            opening.getDetailList().add(det);
            det = new WarehouseOpeningDet();
            det.setProduct(product);
            det.setVariation(product.getVariations().get(2));
            det.setQty(150);
            opening.getDetailList().add(det);
            template.postForEntity(url, opening, WarehouseOpening.class).getBody();
        }

        if (template.getForEntity(url.concat("" + 4), WarehouseOpening.class).getBody() == null) {
            opening = new WarehouseOpening();
            opening.setWarehouse(warehouse4);
            det = new WarehouseOpeningDet();
            det.setProduct(product);
            det.setVariation(product.getVariations().get(0));
            det.setQty(10);
            opening.getDetailList().add(det);
            det = new WarehouseOpeningDet();
            det.setProduct(product);
            det.setVariation(product.getVariations().get(2));
            det.setQty(100);
            opening.getDetailList().add(det);
            template.postForEntity(url, opening, WarehouseOpening.class).getBody();
        }

        if (template.getForEntity(url.concat("" + 5), WarehouseOpening.class).getBody() == null) {
            opening = new WarehouseOpening();
            opening.setWarehouse(warehouse5);
            det = new WarehouseOpeningDet();
            det.setProduct(product);
            det.setVariation(product.getVariations().get(0));
            det.setQty(10);
            opening.getDetailList().add(det);
            template.postForEntity(url, opening, WarehouseOpening.class).getBody();
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Purchase Order">
    private void createPurchaseOrder(int start) {
        String url = API.concat("PurchaseOrder/");

        PurchaseOrder po;
        PurchaseOrderDet poDet;

        if (template.getForEntity(url.concat("" + (1 + start)), PurchaseOrder.class).getBody() == null) {
            po = new PurchaseOrder();
            po.setWarehouse(warehouse1);
            poDet = new PurchaseOrderDet();
            poDet.setProduct(product);
            poDet.setVariation(product.getVariations().get(0));
            poDet.setQuantity(5);
            po.getDetailList().add(poDet);

            template.postForEntity(url, po, PurchaseOrder.class).getBody();
        }

        if (template.getForEntity(url.concat("" + (2 + start)), PurchaseOrder.class).getBody() == null) {
            po = new PurchaseOrder();
            po.setWarehouse(warehouse2);
            poDet = new PurchaseOrderDet();
            poDet.setProduct(product);
            poDet.setVariation(product.getVariations().get(1));
            poDet.setQuantity(1000);
            po.getDetailList().add(poDet);
            poDet = new PurchaseOrderDet();
            poDet.setProduct(product);
            poDet.setVariation(product.getVariations().get(2));
            poDet.setQuantity(12);
            po.getDetailList().add(poDet);
            template.postForEntity(url, po, PurchaseOrder.class).getBody();
        }

        if (template.getForEntity(url.concat("" + (3 + start)), PurchaseOrder.class).getBody() == null) {
            po = new PurchaseOrder();
            po.setWarehouse(warehouse3);
            poDet = new PurchaseOrderDet();
            poDet.setProduct(product);
            poDet.setVariation(product.getVariations().get(0));
            poDet.setQuantity(30);
            po.getDetailList().add(poDet);
            poDet = new PurchaseOrderDet();
            poDet.setProduct(product);
            poDet.setVariation(product.getVariations().get(2));
            poDet.setQuantity(80);
            po.getDetailList().add(poDet);
            template.postForEntity(url, po, PurchaseOrder.class).getBody();
        }

        if (template.getForEntity(url.concat("" + (4 + start)), PurchaseOrder.class).getBody() == null) {
            po = new PurchaseOrder();
            po.setWarehouse(warehouse4);
            poDet = new PurchaseOrderDet();
            poDet.setProduct(product);
            poDet.setVariation(product.getVariations().get(0));
            poDet.setQuantity(5);
            po.getDetailList().add(poDet);

            template.postForEntity(url, po, PurchaseOrder.class).getBody();
        }

        if (template.getForEntity(url.concat("" + (5 + start)), PurchaseOrder.class).getBody() == null) {
            po = new PurchaseOrder();
            po.setWarehouse(warehouse5);
            poDet = new PurchaseOrderDet();
            poDet.setProduct(product);
            poDet.setVariation(product.getVariations().get(0));
            poDet.setQuantity(100);
            po.getDetailList().add(poDet);
            template.postForEntity(url, po, PurchaseOrder.class).getBody();
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Purchase ">
    private void createPurchase() {
        String url = API.concat("Purchase/");
        String urlOrd = API.concat("PurchaseOrder/");

        Purchase p;
        PurchaseDet pDet;

        if (template.getForEntity(url.concat("" + 1), Purchase.class).getBody() == null) {
            p = new Purchase();
            p.setWarehouse(warehouse1);
            PurchaseOrder order = template.getForEntity(urlOrd + 1, PurchaseOrder.class).getBody();
            for (PurchaseOrderDet pod : order.getDetailList()) {
                pDet = new PurchaseDet();
                pDet.setOrderDet(pod);
                pDet.setProduct(pod.getProduct());
                pDet.setVariation(pod.getVariation());
                pDet.setQuantity(pod.getQuantity());
                p.getDetailList().add(pDet);
            }
            template.postForEntity(url, p, Purchase.class).getBody();
        }

        if (template.getForEntity(url.concat("" + 2), Purchase.class).getBody() == null) {
            p = new Purchase();
            p.setWarehouse(warehouse2);
            PurchaseOrder order = template.getForEntity(urlOrd + 2, PurchaseOrder.class).getBody();
            for (PurchaseOrderDet pod : order.getDetailList()) {
                pDet = new PurchaseDet();
                pDet.setOrderDet(pod);
                pDet.setProduct(pod.getProduct());
                pDet.setVariation(pod.getVariation());
                pDet.setQuantity(pod.getQuantity());
                p.getDetailList().add(pDet);
            }
            template.postForEntity(url, p, Purchase.class).getBody();
        }

        if (template.getForEntity(url.concat("" + 3), Purchase.class).getBody() == null) {
            p = new Purchase();
            p.setWarehouse(warehouse3);
            PurchaseOrder order = template.getForEntity(urlOrd + 3, PurchaseOrder.class).getBody();
            for (PurchaseOrderDet pod : order.getDetailList()) {
                pDet = new PurchaseDet();
                pDet.setOrderDet(pod);
                pDet.setProduct(pod.getProduct());
                pDet.setVariation(pod.getVariation());
                pDet.setQuantity(pod.getQuantity());
                p.getDetailList().add(pDet);
            }
            template.postForEntity(url, p, Purchase.class).getBody();
        }

        if (template.getForEntity(url.concat("" + 4), Purchase.class).getBody() == null) {
            p = new Purchase();
            p.setWarehouse(warehouse4);
            PurchaseOrder order = template.getForEntity(urlOrd + 4, PurchaseOrder.class).getBody();
            for (PurchaseOrderDet pod : order.getDetailList()) {
                pDet = new PurchaseDet();
                pDet.setOrderDet(pod);
                pDet.setProduct(pod.getProduct());
                pDet.setVariation(pod.getVariation());
                pDet.setQuantity(pod.getQuantity());
                p.getDetailList().add(pDet);
            }
            template.postForEntity(url, p, Purchase.class).getBody();
        }

        if (template.getForEntity(url.concat("" + 5), Purchase.class).getBody() == null) {
            p = new Purchase();
            p.setWarehouse(warehouse5);
            PurchaseOrder order = template.getForEntity(urlOrd + 5, PurchaseOrder.class).getBody();
            for (PurchaseOrderDet pod : order.getDetailList()) {
                pDet = new PurchaseDet();
                pDet.setOrderDet(pod);
                pDet.setProduct(pod.getProduct());
                pDet.setVariation(pod.getVariation());
                pDet.setQuantity(pod.getQuantity());
                p.getDetailList().add(pDet);
            }
            template.postForEntity(url, p, Purchase.class).getBody();
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Supply Order">
    private void createSupplyOrder(int start) {
        String url = API.concat("SupplyOrder/");

        SupplyOrder po;
        SupplyOrderDet poDet;

        if (template.getForEntity(url.concat("" + (1 + start)), SupplyOrder.class).getBody() == null) {
            po = new SupplyOrder();
            po.setWarehouse(warehouse1);
            poDet = new SupplyOrderDet();
            poDet.setProduct(product);
            poDet.setVariation(product.getVariations().get(0));
            poDet.setQuantity(start == 0 ? 5 : 2);
            po.getDetailList().add(poDet);

            template.postForEntity(url, po, SupplyOrder.class).getBody();
        }

        if (template.getForEntity(url.concat("" + (2 + start)), SupplyOrder.class).getBody() == null) {
            po = new SupplyOrder();
            po.setWarehouse(warehouse2);
            poDet = new SupplyOrderDet();
            poDet.setProduct(product);
            poDet.setVariation(product.getVariations().get(1));
            poDet.setQuantity(start == 0 ? 1000 : 800);
            po.getDetailList().add(poDet);
            poDet = new SupplyOrderDet();
            poDet.setProduct(product);
            poDet.setVariation(product.getVariations().get(2));
            poDet.setQuantity(start == 0 ? 12 : 8);
            po.getDetailList().add(poDet);
            template.postForEntity(url, po, SupplyOrder.class).getBody();
        }

        if (template.getForEntity(url.concat("" + (3 + start)), SupplyOrder.class).getBody() == null) {
            po = new SupplyOrder();
            po.setWarehouse(warehouse3);
            poDet = new SupplyOrderDet();
            poDet.setProduct(product);
            poDet.setVariation(product.getVariations().get(0));
            poDet.setQuantity(start == 0 ? 30 : 50);
            po.getDetailList().add(poDet);
            poDet = new SupplyOrderDet();
            poDet.setProduct(product);
            poDet.setVariation(product.getVariations().get(2));
            poDet.setQuantity(start == 0 ? 80 : 60);
            po.getDetailList().add(poDet);
            template.postForEntity(url, po, SupplyOrder.class).getBody();
        }

        if (template.getForEntity(url.concat("" + (4 + start)), SupplyOrder.class).getBody() == null) {
            po = new SupplyOrder();
            po.setWarehouse(warehouse4);
            poDet = new SupplyOrderDet();
            poDet.setProduct(product);
            poDet.setVariation(product.getVariations().get(0));
            poDet.setQuantity(start == 0 ? 5 : 3);
            po.getDetailList().add(poDet);

            template.postForEntity(url, po, SupplyOrder.class).getBody();
        }

        if (template.getForEntity(url.concat("" + (5 + start)), SupplyOrder.class).getBody() == null) {
            po = new SupplyOrder();
            po.setWarehouse(warehouse5);
            poDet = new SupplyOrderDet();
            poDet.setProduct(product);
            poDet.setVariation(product.getVariations().get(0));
            poDet.setQuantity(start == 0 ? 100 : 10);
            po.getDetailList().add(poDet);
            template.postForEntity(url, po, SupplyOrder.class).getBody();
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Supply">
    private void createSupply() {
        String url = API.concat("Supply/");
        String urlOrd = API.concat("SupplyOrder/");

        Supply p;
        SupplyDet pDet;

        if (template.getForEntity(url.concat("" + 1), Supply.class).getBody() == null) {
            p = new Supply();
            p.setWarehouse(warehouse1);
            SupplyOrder order = template.getForEntity(urlOrd + 1, SupplyOrder.class).getBody();
            for (SupplyOrderDet pod : order.getDetailList()) {
                pDet = new SupplyDet();
                pDet.setOrderDet(pod);
                pDet.setProduct(pod.getProduct());
                pDet.setVariation(pod.getVariation());
                pDet.setQuantity(pod.getQuantity());
                p.getDetailList().add(pDet);
            }
            template.postForEntity(url, p, Supply.class).getBody();
        }

        if (template.getForEntity(url.concat("" + 2), Supply.class).getBody() == null) {
            p = new Supply();
            p.setWarehouse(warehouse2);
            SupplyOrder order = template.getForEntity(urlOrd + 2, SupplyOrder.class).getBody();
            for (SupplyOrderDet pod : order.getDetailList()) {
                pDet = new SupplyDet();
                pDet.setOrderDet(pod);
                pDet.setProduct(pod.getProduct());
                pDet.setVariation(pod.getVariation());
                pDet.setQuantity(pod.getQuantity());
                p.getDetailList().add(pDet);
            }
            template.postForEntity(url, p, Supply.class).getBody();
        }

        if (template.getForEntity(url.concat("" + 3), Supply.class).getBody() == null) {
            p = new Supply();
            p.setWarehouse(warehouse3);
            SupplyOrder order = template.getForEntity(urlOrd + 3, SupplyOrder.class).getBody();
            for (SupplyOrderDet pod : order.getDetailList()) {
                pDet = new SupplyDet();
                pDet.setOrderDet(pod);
                pDet.setProduct(pod.getProduct());
                pDet.setVariation(pod.getVariation());
                pDet.setQuantity(pod.getQuantity());
                p.getDetailList().add(pDet);
            }
            template.postForEntity(url, p, Supply.class).getBody();
        }

        if (template.getForEntity(url.concat("" + 4), Supply.class).getBody() == null) {
            p = new Supply();
            p.setWarehouse(warehouse4);
            SupplyOrder order = template.getForEntity(urlOrd + 4, SupplyOrder.class).getBody();
            for (SupplyOrderDet pod : order.getDetailList()) {
                pDet = new SupplyDet();
                pDet.setOrderDet(pod);
                pDet.setProduct(pod.getProduct());
                pDet.setVariation(pod.getVariation());
                pDet.setQuantity(pod.getQuantity());
                p.getDetailList().add(pDet);
            }
            template.postForEntity(url, p, Supply.class).getBody();
        }

        if (template.getForEntity(url.concat("" + 5), Supply.class).getBody() == null) {
            p = new Supply();
            p.setWarehouse(warehouse5);
            SupplyOrder order = template.getForEntity(urlOrd + 5, SupplyOrder.class).getBody();
            for (SupplyOrderDet pod : order.getDetailList()) {
                pDet = new SupplyDet();
                pDet.setOrderDet(pod);
                pDet.setProduct(pod.getProduct());
                pDet.setVariation(pod.getVariation());
                pDet.setQuantity(pod.getQuantity());
                p.getDetailList().add(pDet);
            }
            template.postForEntity(url, p, Supply.class).getBody();
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Report">
    private void report() {
        String url = ("/report/");
        List<List> report = template.getForEntity(url, List.class).getBody();
        String formatted = "|%-10s%-13s%-13s%-7s%10s%10s%15s%10s%10s%15s|%n";
        System.out.printf(formatted, "Location", "Warehouse", "Item", "Size", "In Stock", "Avl.Qty", "In Transit", "MOQ", "QPB", "Reorder Point");
        System.out.printf("|=================================================================================================================|%n");
        report.forEach((d) -> {
            System.out.printf(formatted, d.toArray());
            System.out.printf("|-----------------------------------------------------------------------------------------------------------------|%n");
        });
        System.out.printf("|=================================================================================================================|%n");
    }
    //</editor-fold>
}
