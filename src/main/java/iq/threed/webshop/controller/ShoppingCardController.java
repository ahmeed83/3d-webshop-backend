package iq.threed.webshop.controller;

import iq.threed.webshop.dto.ShoppingCardItemDto;
import iq.threed.webshop.entity.ShoppingCardEntity;
import iq.threed.webshop.service.ShoppingCardItemService;
import iq.threed.webshop.service.ShoppingCardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/shopping-card")
public class ShoppingCardController {

    private final ShoppingCardService shoppingCardService;
    private final ShoppingCardItemService shoppingCardItemService;

    public ShoppingCardController(final ShoppingCardService shoppingCardService, final ShoppingCardItemService shoppingCardItemService) {
        this.shoppingCardService = shoppingCardService;
        this.shoppingCardItemService = shoppingCardItemService;
    }

    @GetMapping
    public Optional<ShoppingCardEntity> getShoppingCard() {
        return shoppingCardService.getShoppingCard(1L);
    }

    @PostMapping("/add-item")
    public void addItemToShoppingCard(final @RequestBody ShoppingCardItemDto inputShoppingCardDto) {
        shoppingCardItemService.addItemToShoppingCardCard(inputShoppingCardDto);
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<?> deleteItemFromShoppingCard(final @PathVariable Long itemId) {
        shoppingCardItemService.deleteItem(itemId);
        return ResponseEntity.accepted().build();
    }
}