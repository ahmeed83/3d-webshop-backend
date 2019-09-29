package iq.threed.webshop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "category")
public class CategoryEntity extends AuditModel {
    private String name;
}