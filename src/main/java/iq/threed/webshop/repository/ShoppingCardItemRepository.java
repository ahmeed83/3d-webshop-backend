package iq.threed.webshop.repository;

import iq.threed.webshop.entity.ShoppingCardItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ShoppingCardItemRepository extends JpaRepository<ShoppingCardItemEntity, Long> {
}
