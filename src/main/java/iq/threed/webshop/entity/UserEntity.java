package iq.threed.webshop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "user")
public class UserEntity extends AuditModel {

    @Column(nullable = false, unique = true)
    private String username;
    private String password;
    private boolean enabled;
}

