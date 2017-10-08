/*
 * Copyright (C) 2017 Ali Imran, All Rights Reserved.
 */
package task.esw.vantibolli.test.maps;

import org.testng.annotations.Test;
import task.esw.vantibolli.maps.Brand;
import task.esw.vantibolli.maps.BrandAssert;

/**
 *
 * @author Ali Imran
 */
public class BrandTest {

    @Test
    void testBrand() {
        Brand b = new Brand();
        b.setId(1l);
        b.setTitle("Brand1");

        BrandAssert.assertThat(b).hasTitle("Brand1");
    }

}
