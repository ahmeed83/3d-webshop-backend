package iq.threed.webshop.controller;

import iq.threed.webshop.dto.ShoppingCartItemDto;
import iq.threed.webshop.entity.ShoppingCartEntity;
import iq.threed.webshop.service.ShoppingCartItemService;
import iq.threed.webshop.service.ShoppingCartService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Rest Controller for shopping cart.
 */
@RestController
@RequestMapping("/api/shopping-cart")
public class ShoppingCartController {

    /**
     * ShoppingCart Service.
     */
    private final ShoppingCartService shoppingCartService;
    /**
     * ShoppingCart Item Service.
     */
    private final ShoppingCartItemService shoppingCartItemService;

    /**
     * Constructor.
     *
     * @param shoppingCartServiceVal     shoppingCartService
     * @param shoppingCartItemServiceVal shoppingCartItemService
     */
    public ShoppingCartController(final ShoppingCartService shoppingCartServiceVal,
                                  final ShoppingCartItemService shoppingCartItemServiceVal) {
        this.shoppingCartService = shoppingCartServiceVal;
        this.shoppingCartItemService = shoppingCartItemServiceVal;
    }

    /**
     * Rest call to get the shopping cart.
     *
     * @return shopping cart.
     */
    @GetMapping
    public final Optional<ShoppingCartEntity> getShoppingCart() {
        return shoppingCartService.getShoppingCart(1L);
    }

    /**
     * Rest call to add item to the shopping cart.
     */
    @PostMapping("/add-item")
    public final void addItemToShoppingCart(final @RequestBody ShoppingCartItemDto inputShoppingCartDto) {
        shoppingCartItemService.addItemToShoppingCartCart(inputShoppingCartDto);
    }

    /**
     * Rest call to delete item from the shopping cart.
     */
    @DeleteMapping("/{itemId}")
    public final void deleteItemFromShoppingCart(final @PathVariable Long itemId) {
        shoppingCartItemService.deleteShoppingCartItem(itemId);
    }
}
