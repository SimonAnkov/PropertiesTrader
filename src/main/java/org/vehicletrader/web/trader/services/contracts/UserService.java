package org.vehicletrader.web.trader.services.contracts;

import org.vehicletrader.web.trader.models.users.User;

public interface UserService {
    User getUserById(int id);

    User getUserByUsername(String username);

    User getUserByEmail(String email);
}
