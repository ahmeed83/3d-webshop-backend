package iq.threed.webshop.dto;

import lombok.Builder;
import lombok.Data;

/**
 * Product DTO class.
 *
 * @author @Ahmed Aziz
 * @version 1.1
 */
@Data
@Builder
public class ProductDto {
    /**
     * Product id.
     */
    private Long id;
    /**
     * Image name.
     */
    private String imageName;
    /**
     * Product name.
     */
    private String name;
    /**
     * Product text.
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
     * Category name.
     */
    private String categoryName;
    /**
     * Category id.
     */
    private Long categoryId;
}
