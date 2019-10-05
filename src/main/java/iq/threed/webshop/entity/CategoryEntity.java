package iq.threed.webshop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Category entity.
 *
 * @author @Ahmed Aziz
 * @version 1.1
 */
@Entity
@Getter
@Setter
@Table(name = "category")
public class CategoryEntity extends AuditModel {
    /**
     * Category name.
     */
    private String name;
}
