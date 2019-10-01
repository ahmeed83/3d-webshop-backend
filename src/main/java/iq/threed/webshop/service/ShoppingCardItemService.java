package iq.threed.webshop.service;

import iq.threed.webshop.dto.ShoppingCardItemDto;
import iq.threed.webshop.entity.ProductEntity;
import iq.threed.webshop.entity.ShoppingCardEntity;
import iq.threed.webshop.entity.ShoppingCardItemEntity;
import iq.threed.webshop.repository.ProductRepository;
import iq.threed.webshop.repository.ShoppingCardItemRepository;
import iq.threed.webshop.repository.ShoppingCardRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShoppingCardItemService {

    private final ShoppingCardItemRepository shoppingCardItemRepository;
    private final ShoppingCardRepository shoppingCardRepository;

    private final ProductRepository productRepository;

    public ShoppingCardItemService(final ShoppingCardItemRepository shoppingCardItemRepository, final ShoppingCardRepository shoppingCardRepository, final ProductRepository productRepository) {
        this.shoppingCardItemRepository = shoppingCardItemRepository;
        this.shoppingCardRepository = shoppingCardRepository;
        this.productRepository = productRepository;
    }

    public void addItemToShoppingCardCard(final ShoppingCardItemDto inputShoppingCardDto) {
        shoppingCardItemRepository.save(mapFromDtoToEntity(inputShoppingCardDto));
    }

    private ShoppingCardItemEntity mapFromDtoToEntity(final ShoppingCardItemDto inputShoppingCardDto) {
        final Optional<ShoppingCardEntity> cardId;

        if (inputShoppingCardDto.getShoppingCartId() != 0) {
            cardId = shoppingCardRepository.findById(inputShoppingCardDto.getShoppingCartId());
        } else {
            cardId = Optional.of(new ShoppingCardEntity());
        }

        final Optional<ProductEntity> productId = productRepository.findById(inputShoppingCardDto.getProductId());

        ShoppingCardItemEntity shoppingCardItemEntity = new ShoppingCardItemEntity();
        shoppingCardItemEntity.setId(inputShoppingCardDto.getId());
        shoppingCardItemEntity.setProductId(productId.get());
        shoppingCardItemEntity.setQuantity(inputShoppingCardDto.getQuantity());
        shoppingCardItemEntity.setCart(cardId.get());
        return shoppingCardItemEntity;
    }

    public void deleteItem(final Long itemId) {
        shoppingCardItemRepository.deleteById(itemId);
    }
}
