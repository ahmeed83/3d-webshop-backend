package iq.threed.webshop.service;

import iq.threed.webshop.entity.UserEntity;
import iq.threed.webshop.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * UserDetailsService for the web-shop application.
 */
@Service
public class ThreeDUserDetailsService implements UserDetailsService {

    /**
     * User repository.
     */
    private UserRepository userRepository;

    /**
     * Constructor.
     *
     * @param userRepository userRepository
     */
    public ThreeDUserDetailsService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Load the user by username.
     *
     * @param userName username
     * @return threeDUserDetailsService.
     * @throws UsernameNotFoundException UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(final String userName) throws UsernameNotFoundException {
        final Optional<UserEntity> user = userRepository.findByUserName(userName);
        return user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));
    }
}
