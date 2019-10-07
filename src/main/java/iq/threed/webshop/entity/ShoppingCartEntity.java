package iq.threed.webshop.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * ShoppingCart Entity.
 */
@Entity
@Getter
@Setter
@Table(name = "cart")
public class ShoppingCartEntity extends AuditModel {

    /**
     * shoppingCart item entities.
     */
    @JsonManagedReference
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private Set<ShoppingCartItemEntity> shoppingCartItemEntities = new HashSet<>();
}
