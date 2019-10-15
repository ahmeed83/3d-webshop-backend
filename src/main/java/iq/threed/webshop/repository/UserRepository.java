package iq.threed.webshop.repository;

import iq.threed.webshop.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * User Repository.
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    /**
     * Find user name.
     *
     * @param userName userName
     * @return user entity.
     */
    Optional<UserEntity> findByUserName(String userName);
}
