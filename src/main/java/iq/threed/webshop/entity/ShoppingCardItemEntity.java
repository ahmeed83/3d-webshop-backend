package iq.threed.webshop.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "cart_item")
public class ShoppingCardItemEntity extends AuditModel {
    private Long quantity;

    @OneToOne
    @JoinColumn(name = "product_id")
    private ProductEntity productId;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id", nullable = false)
    private ShoppingCardEntity cart;
}