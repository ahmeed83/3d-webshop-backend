package iq.threed.webshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ShoppingCardItemDto {

    private Long id;
    private Long quantity;
    private Long productId;
    private Long shoppingCartId;
}
