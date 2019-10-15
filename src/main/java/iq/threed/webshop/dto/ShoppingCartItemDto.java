package iq.threed.webshop.dto;

import lombok.Data;

/**
 * Shopping Cart Item Dto.
 */
@Data
public class ShoppingCartItemDto {

    /**
     * Id.
     */
    private Long id;
    /**
     * Quantity.
     */
    private Long quantity;
    /**
     * Product Id.
     */
    private Long productId;
    /**
     * ShoppingCart Id.
     */
    private Long shoppingCartId;
}
