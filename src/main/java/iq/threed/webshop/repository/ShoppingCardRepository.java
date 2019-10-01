package iq.threed.webshop.repository;

import iq.threed.webshop.entity.ShoppingCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ShoppingCardRepository extends JpaRepository<ShoppingCardEntity, Long> {
}
