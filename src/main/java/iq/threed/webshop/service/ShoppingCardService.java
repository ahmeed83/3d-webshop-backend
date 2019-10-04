package iq.threed.webshop.service;

import iq.threed.webshop.entity.ShoppingCardEntity;
import iq.threed.webshop.repository.ShoppingCardRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShoppingCardService {

    private final ShoppingCardRepository shoppingCardRepository;

    public ShoppingCardService(final ShoppingCardRepository shoppingCardRepository) {
        this.shoppingCardRepository = shoppingCardRepository;
    }

    public Optional<ShoppingCardEntity> getShoppingCard(Long shoppingCardId) {
        return shoppingCardRepository.findById(shoppingCardId);
    }

    public void deleteShoppingCard(final Long shoppingCartId) {
        shoppingCardRepository.deleteById(shoppingCartId);
    }
}
