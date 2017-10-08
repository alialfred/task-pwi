/*
 * Copyright (C) 2017 Ali Imran, All Rights Reserved.
 */
package task.esw.vantibolli.maps;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * Data Entity Class for Products
 *
 * @author Ali Imran
 *
 */
@Entity
@Table(name = "products")
@SuppressWarnings("PersistenceUnitPresent")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Title", nullable = false)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(name = "Product_Type", nullable = false)
    private ProductType productType;

    @org.hibernate.annotations.OrderBy(clause = "Sr_No")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "product")
    private List<ProductVariation> variations = new ArrayList<>(0);

    /**
     *
     */
    public Product() {
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
     *
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get the value of productType
     *
     * @return the value of productType
     */
    public ProductType getProductType() {
        return productType;
    }

    /**
     * Set the value of productType
     *
     * @param productType new value of productType
     */
    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    /**
     * Get the value of variations
     *
     * @return the value of variations
     */
    public List<ProductVariation> getVariations() {
        return variations;
    }

    /**
     * Set the value of variations
     *
     * @param variations new value of variations
     */
    public void setVariations(List<ProductVariation> variations) {
        this.variations = variations;
        this.variations.forEach((v) -> v.setProduct(this));
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
        final Product other = (Product) obj;
        return Objects.equals(this.id, other.id);
    }

    /**
     *
     * @return this as a formatted string
     */
    @Override
    public String toString() {
        return String.format("%s: %s, %s", getId(), getTitle(), getVariations());
    }
}
