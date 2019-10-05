package iq.threed.webshop.repository;

import iq.threed.webshop.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Category repo.
 */
@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
}

