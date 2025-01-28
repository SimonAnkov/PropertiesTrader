package org.vehicletrader.web.trader.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.vehicletrader.web.trader.models.users.User;
import org.vehicletrader.web.trader.repositories.contracts.UserRepository;

import java.util.Optional;

@Service
@DependsOn({"jwtAuthFilter"})
public class UserInfoService implements UserDetailsService {

    private final UserRepository repository;

    @Autowired
    public UserInfoService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userDetail = repository.findByUsername(username); // Assuming 'email' is used as username

        // Converting UserInfo to UserDetails
        return userDetail.map(UserInfoDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }
}
