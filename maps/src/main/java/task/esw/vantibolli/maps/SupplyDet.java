/*
 * Copyright (C) 2017 Ali Imran, All Rights Reserved.
 */
package task.esw.vantibolli.maps;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * Data Entity Class for Purchase Details
 *
 * @author Ali Imran
 *
 */
@Entity
@Table(name = "supply_det")
@SuppressWarnings("PersistenceUnitPresent")
@JsonIgnoreProperties(ignoreUnknown = true)
public class SupplyDet implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Sr_No")
    private int srNo;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Supply_Id", nullable = false)
    private Supply supply;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Order_Det_Id", nullable = false)
    private SupplyOrderDet orderDet;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Product_Id", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Product_Variation_Id", nullable = false)
    private ProductVariation variation;

    @Column(name = "Quantity")
    private float quantity;

    /**
     *
     */
    public SupplyDet() {
    }

    /**
     *
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get the value of srNo
     *
     * @return the value of srNo
     */
    public int getSrNo() {
        return srNo;
    }

    /**
     * Set the value of srNo
     *
     * @param srNo new value of srNo
     */
    public void setSrNo(int srNo) {
        this.srNo = srNo;
    }

    /**
     * Get the value of supply
     *
     * @return the value of supply
     */
    public Supply getSupply() {
        return supply;
    }

    /**
     * Set the value of supply
     *
     * @param supply new value of supply
     */
    public void setSupply(Supply supply) {
        this.supply = supply;
    }

    /**
     * Get the value of orderDet
     *
     * @return the value of orderDet
     */
    public SupplyOrderDet getOrderDet() {
        return orderDet;
    }

    /**
     * Set the value of orderDet
     *
     * @param orderDet new value of orderDet
     */
    public void setOrderDet(SupplyOrderDet orderDet) {
        this.orderDet = orderDet;
    }

    /**
     * Get the value of product
     *
     * @return the value of product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Set the value of product
     *
     * @param product new value of product
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Get the value of variation
     *
     * @return the value of variation
     */
    public ProductVariation getVariation() {
        return variation;
    }

    /**
     * Set the value of variation
     *
     * @param variation new value of variation
     */
    public void setVariation(ProductVariation variation) {
        this.variation = variation;
    }

    /**
     * Get the value of quantity
     *
     * @return the value of quantity
     */
    public float getQuantity() {
        return quantity;
    }

    /**
     * Set the value of quantity
     *
     * @param quantity new value of quantity
     */
    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SupplyDet other = (SupplyDet) obj;
        return Objects.equals(this.id, other.id);
    }

    /**
     *
     * @return this as a formatted string
     */
    @Override
    public String toString() {
        return String.format("%s: %s", getId(), getProduct());
    }
}
