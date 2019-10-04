package iq.threed.webshop.dto;

import lombok.Data;

@Data
public class OrderDto {
    private Long id;
    private Long userId;
    private Long shoppingCartId;
}
