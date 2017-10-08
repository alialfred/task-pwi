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
@Table(name = "wh_vari_det")
@SuppressWarnings("PersistenceUnitPresent")
@JsonIgnoreProperties(ignoreUnknown = true)
public class WarehouseVariationDet implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Sr_No")
    private int srNo;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Wh_Vari_Id", nullable = false)
    private WarehouseVariation wharehouseVariation;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Product_Id", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Product_Variation_Id", nullable = false)
    private ProductVariation variation;

    @Column(name = "Min_Order_Qty")
    private float moq;

    @Column(name = "Qty_Per_Box")
    private float qpb;

    @Column(name = "Reorder_Point")
    private float rop;

    /**
     *
     */
    public WarehouseVariationDet() {
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
     * Get the value of wharehouseVariation
     *
     * @return the value of wharehouseVariation
     */
    public WarehouseVariation getWharehouseVariation() {
        return wharehouseVariation;
    }

    /**
     * Set the value of wharehouseVariation
     *
     * @param wharehouseVariation new value of wharehouseVariation
     */
    public void setWharehouseVariation(WarehouseVariation wharehouseVariation) {
        this.wharehouseVariation = wharehouseVariation;
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
     * Get the value of moq
     *
     * @return the value of moq
     */
    public float getMoq() {
        return moq;
    }

    /**
     * Set the value of moq
     *
     * @param moq new value of moq
     */
    public void setMoq(float moq) {
        this.moq = moq;
    }

    /**
     * Get the value of qpb
     *
     * @return the value of qpb
     */
    public float getQpb() {
        return qpb;
    }

    /**
     * Set the value of qpb
     *
     * @param qpb new value of qpb
     */
    public void setQpb(float qpb) {
        this.qpb = qpb;
    }

    /**
     * Get the value of rop
     *
     * @return the value of rop
     */
    public float getRop() {
        return rop;
    }

    /**
     * Set the value of rop
     *
     * @param rop new value of rop
     */
    public void setRop(float rop) {
        this.rop = rop;
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
        final WarehouseVariationDet other = (WarehouseVariationDet) obj;
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
