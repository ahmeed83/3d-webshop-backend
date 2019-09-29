package iq.threed.webshop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "product")
public class ProductEntity extends AuditModel {
    private String name;
    private String code;
    private String description;
    private Byte[] image;
    private Double price;
    private int quantity;
    private Long categoryId;
}
