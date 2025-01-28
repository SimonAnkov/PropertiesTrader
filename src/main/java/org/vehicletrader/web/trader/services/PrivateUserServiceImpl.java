package org.vehicletrader.web.trader.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.vehicletrader.web.trader.exceptions.EntityDuplicateException;
import org.vehicletrader.web.trader.exceptions.EntityNotFoundException;
import org.vehicletrader.web.trader.models.users.Private;
import org.vehicletrader.web.trader.models.users.User;
import org.vehicletrader.web.trader.repositories.contracts.PrivateUserRepository;
import org.vehicletrader.web.trader.services.contracts.PrivateUserService;
import org.vehicletrader.web.trader.services.contracts.UserService;

@Service
public class PrivateUserServiceImpl implements PrivateUserService {

    private final PrivateUserRepository privateUserRepository;
    private final UserService userService;

    @Autowired
    public PrivateUserServiceImpl(PrivateUserRepository privateUserRepository,
                                  UserService userService) {
        this.privateUserRepository = privateUserRepository;
        this.userService = userService;
    }


    @Override
    public void createPrivateUser(Private privateUser) {
        try {
            privateUserRepository.save(privateUser);
        } catch (DataIntegrityViolationException e) {
            StringBuilder errorMessage = new StringBuilder();

            if (e.getMessage().contains("username")) {
                errorMessage.append("Username already exists!\n");
            }
            if (e.getMessage().contains("email")) {
                errorMessage.append("Email already exists!\n");
            }
            if (e.getMessage().contains("phone")) {
                errorMessage.append("Phone already exists!\n");
            }
            throw new EntityDuplicateException(errorMessage.toString());
        }
    }

    @Override
    public void updatePrivateUser(Private privateUser) {

    }

    @Override
    public void deletePrivateUser(Private privateUser) {

    }

    @Override
    public Private getPrivateUserById(int id) {
        return privateUserRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Private", id));
    }

    @Override
    public Private getPrivateUserByUsername(String username) {
        User user = userService.getUserByUsername(username);
        if (!user.getRole().getRole().equals("ROLE_PRIVATE")) {
            throw new EntityNotFoundException("User with username " + username + " is not a Private User");
        }

        return getPrivateUserById(user.getId());
    }
}
