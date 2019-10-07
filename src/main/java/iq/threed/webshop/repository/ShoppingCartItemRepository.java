package iq.threed.webshop.repository;

import iq.threed.webshop.entity.ShoppingCartItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ShoppingCartItem Repository.
 */
@Repository
public interface ShoppingCartItemRepository extends JpaRepository<ShoppingCartItemEntity, Long> {
}
