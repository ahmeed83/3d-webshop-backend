package iq.threed.webshop.service;

import iq.threed.webshop.entity.ShoppingCartEntity;
import iq.threed.webshop.repository.ShoppingCartRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * ShoppingCart Service.
 */
@Service
public class ShoppingCartService {

    /**
     * Shopping cart repository.
     */
    private final ShoppingCartRepository shoppingCartRepository;

    /**
     * Constructor.
     *
     * @param shoppingCartRepositoryVal shoppingCartRepository
     */
    public ShoppingCartService(final ShoppingCartRepository shoppingCartRepositoryVal) {
        this.shoppingCartRepository = shoppingCartRepositoryVal;
    }

    /**
     * Gets shopping cart.
     *
     * @param shoppingCartId shoppingCartId
     * @return shopping cart entity
     */
    public final Optional<ShoppingCartEntity> getShoppingCart(final Long shoppingCartId) {
        return shoppingCartRepository.findById(shoppingCartId);
    }

    /**
     * Deletes shopping cart.
     *
     * @param shoppingCartId shoppingCartId
     */
    public final void deleteShoppingCart(final Long shoppingCartId) {
        shoppingCartRepository.deleteById(shoppingCartId);
    }
}
