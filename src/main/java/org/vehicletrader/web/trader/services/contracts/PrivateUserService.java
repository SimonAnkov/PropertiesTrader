package org.vehicletrader.web.trader.services.contracts;

import org.vehicletrader.web.trader.models.users.Private;

public interface PrivateUserService {
    Private getPrivateUserById(int id);

    Private getPrivateUserByUsername(String username);

    void createPrivateUser(Private privateUser);

    void updatePrivateUser(Private privateUser);

    void deletePrivateUser(Private privateUser);
}
