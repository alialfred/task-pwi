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
@Table(name = "purchase_orders_det")
@SuppressWarnings("PersistenceUnitPresent")
@JsonIgnoreProperties(ignoreUnknown = true)
public class PurchaseOrderDet implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Sr_No")
    private int srNo;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Order_Id", nullable = true)
    private PurchaseOrder purchaseOrder;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Product_Id", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Product_Variation_Id", nullable = false)
    private ProductVariation variation;

    @Column(name = "Quantity")
    private float quantity;

    @Column(name = "Purchased")
    private boolean purchased;

    /**
     *
     */
    public PurchaseOrderDet() {
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
     * Get the value of purchaseOrder
     *
     * @return the value of purchaseOrder
     */
    public PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }

    /**
     * Set the value of purchaseOrder
     *
     * @param purchaseOrder new value of purchaseOrder
     */
    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
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

    /**
     * Get the value of purchased
     *
     * @return the value of purchased
     */
    public boolean isPurchased() {
        return purchased;
    }

    /**
     * Set the value of purchased
     *
     * @param purchased new value of purchased
     */
    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
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
        final PurchaseOrderDet other = (PurchaseOrderDet) obj;
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
