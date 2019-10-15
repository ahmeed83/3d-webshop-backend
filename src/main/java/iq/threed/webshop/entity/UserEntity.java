package iq.threed.webshop.entity;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Collection;
import java.util.Collections;

/**
 * User Entity.
 */
@Entity
@Setter
@Table(name = "user")
@RequiredArgsConstructor
public class UserEntity extends AuditModel implements UserDetails {

    /**
     * User name.
     */
    @Column(name = "user_name", nullable = false, unique = true)
    private String userName;

    /**
     * Password name.
     */
    @Column(name = "user_password", nullable = false)
    private String userPassword;

    /**
     * User enabled.
     */
    private boolean enabled;

    /**
     * Get authorities.
     *
     * @return authorities
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    /**
     * User password.
     *
     * @return password.
     */
    @Override
    public String getPassword() {
        return userPassword;
    }

    /**
     * User name.
     *
     * @return username
     */
    @Override
    public String getUsername() {
        return userName;
    }

    /**
     * Is account non expired.
     *
     * @return true
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Is account non locked.
     *
     * @return true
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Is credentials non expired.
     *
     * @return true
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Is the user enabled.
     *
     * @return true
     */
    @Override
    public boolean isEnabled() {
        return enabled;
    }
}

