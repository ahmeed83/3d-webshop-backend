package iq.threed.webshop.service;

import iq.threed.webshop.dto.ShoppingCartItemDto;
import iq.threed.webshop.entity.ProductEntity;
import iq.threed.webshop.entity.ShoppingCartEntity;
import iq.threed.webshop.entity.ShoppingCartItemEntity;
import iq.threed.webshop.repository.ProductRepository;
import iq.threed.webshop.repository.ShoppingCartItemRepository;
import iq.threed.webshop.repository.ShoppingCartRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * ShoppingCartItem Service.
 */
@Service
public class ShoppingCartItemService {

    /**
     * shopping cart item repository.
     */
    private final ShoppingCartItemRepository shoppingCartItemRepository;

    /**
     * shopping cart repository.
     */
    private final ShoppingCartRepository shoppingCartRepository;

    /**
     * product repository.
     */
    private final ProductRepository productRepository;

    /**
     * Constructor.
     *
     * @param shoppingCartItemRepositoryVal shoppingCartItemRepository
     * @param shoppingCartRepositoryVal     shoppingCartRepository
     * @param productRepositoryVal          productRepository
     */
    public ShoppingCartItemService(final ShoppingCartItemRepository shoppingCartItemRepositoryVal,
                                   final ShoppingCartRepository shoppingCartRepositoryVal,
                                   final ProductRepository productRepositoryVal) {
        this.shoppingCartItemRepository = shoppingCartItemRepositoryVal;
        this.shoppingCartRepository = shoppingCartRepositoryVal;
        this.productRepository = productRepositoryVal;
    }

    /**
     * Add item to the chopping cart.
     */
    public final void addItemToShoppingCartCart(final ShoppingCartItemDto inputShoppingCartDtoVal) {
        shoppingCartItemRepository.save(mapFromDtoToEntity(inputShoppingCartDtoVal));
    }

    /**
     * TODO: to be removed by mapstruct.
     */
    private ShoppingCartItemEntity mapFromDtoToEntity(final ShoppingCartItemDto inputShoppingCartDto) {
        final Optional<ShoppingCartEntity> cartId;

        if (inputShoppingCartDto.getShoppingCartId() != 0) {
            cartId = shoppingCartRepository.findById(inputShoppingCartDto.getShoppingCartId());
        } else {
            cartId = Optional.of(new ShoppingCartEntity());
        }

        final Optional<ProductEntity> productId = productRepository.findById(inputShoppingCartDto.getProductId());

        ShoppingCartItemEntity shoppingCartItemEntity = new ShoppingCartItemEntity();
        shoppingCartItemEntity.setId(inputShoppingCartDto.getId());
        shoppingCartItemEntity.setProductId(productId.get());
        shoppingCartItemEntity.setQuantity(inputShoppingCartDto.getQuantity());
        shoppingCartItemEntity.setCart(cartId.get());
        return shoppingCartItemEntity;
    }

    /**
     * Delete shopping cart item.
     */
    public final void deleteShoppingCartItem(final Long itemId) {
        shoppingCartItemRepository.deleteById(itemId);
    }
}

