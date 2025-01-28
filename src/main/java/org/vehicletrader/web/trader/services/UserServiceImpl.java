package org.vehicletrader.web.trader.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vehicletrader.web.trader.exceptions.EntityNotFoundException;
import org.vehicletrader.web.trader.models.users.User;
import org.vehicletrader.web.trader.repositories.contracts.UserRepository;
import org.vehicletrader.web.trader.services.contracts.UserService;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User getUserById(int id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User", id));
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("User", "username", username));
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new EntityNotFoundException("User", "email", email));
    }
}
