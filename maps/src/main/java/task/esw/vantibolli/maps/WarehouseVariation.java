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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "wh_vari")
@SuppressWarnings("PersistenceUnitPresent")
@JsonIgnoreProperties(ignoreUnknown = true)
public class WarehouseVariation implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Warehouse_Id", nullable = false)
    private Warehouse warehouse;

    @org.hibernate.annotations.OrderBy(clause = "Sr_No")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "wharehouseVariation")
    private List<WarehouseVariationDet> detailList = new ArrayList<>(0);

    /**
     *
     */
    public WarehouseVariation() {
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
    public Warehouse getWarehouse() {
        return warehouse;
    }

    /**
     *
     * @param warehouse
     */
    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    /**
     * Get the value of detailList
     *
     * @return the value of detailList
     */
    public List<WarehouseVariationDet> getDetailList() {
        return detailList;
    }

    /**
     * Set the value of detailList
     *
     * @param detailList new value of detailList
     */
    public void setDetailList(List<WarehouseVariationDet> detailList) {
        this.detailList = detailList;
        this.detailList.forEach((d)->d.setWharehouseVariation(this));
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
        final WarehouseVariation other = (WarehouseVariation) obj;
        return Objects.equals(this.id, other.id);
    }

    /**
     *
     * @return this as a formatted string
     */
    @Override
    public String toString() {
        return String.format("%s: %s", getId(), getDetailList());
    }
}
