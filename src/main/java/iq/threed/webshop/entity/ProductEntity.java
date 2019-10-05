package iq.threed.webshop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Product entity.
 *
 * @author @Ahmed Aziz
 * @version 1.1
 */
@Entity
@Getter
@Setter
@Table(name = "product")
public class ProductEntity extends AuditModel {
    /**
     * Product image name.
     */
    private String imageName;
    /**
     * Product name.
     */
    private String name;
    /**
     * Product code.
     */
    private String code;
    /**
     * Product description.
     */
    private String description;
    /**
     * Product price.
     */
    private double price;
    /**
     * Product quantity.
     */
    private int quantity;
    /**
     * Product category.
     */
    private Long categoryId;
}
