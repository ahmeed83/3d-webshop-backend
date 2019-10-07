package iq.threed.webshop.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Entity for the shopping cart.
 */
@Entity
@Getter
@Setter
@Table(name = "cart_item")
public class ShoppingCartItemEntity extends AuditModel {
    /**
     * Quantity of the item in the database.
     */
    private Long quantity;

    /**
     * product Id.
     */
    @OneToOne
    @JoinColumn(name = "product_id")
    private ProductEntity productId;

    /**
     * shopping cart entity.
     */
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id", nullable = false)
    private ShoppingCartEntity cart;
}
