/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task.esw.vantibolli.validators;

import java.util.Objects;
import task.esw.vantibolli.maps.ProductType;
import task.esw.vantibolli.maps.Supply;

/**
 *
 * @author mohammad
 */
public class SupplyValidator implements DataValidator<Supply> {

    /**
     *
     * @param entity
     * @throws Exception
     */
    @Override
    public void validate(Supply entity) throws Exception {
        entity.getDetailList().forEach((d) -> {
            if (Objects.isNull(d.getProduct())) {
                throw new IllegalArgumentException("Product can not be null");
            } else if (Objects.isNull(d.getVariation())) {
                throw new IllegalArgumentException("Variation can not be null");
            } else if (!ProductType.FINISHED_PRODUCT.equals(d.getProduct().getProductType())) {
                throw new IllegalArgumentException("Only a finshied product can be supply.");
            }
        });
    }

}
