package org.vehicletrader.web.trader.services.contracts;

import org.vehicletrader.web.trader.models.users.Role;

public interface RoleService {
    Role getRole(String roleName);

    Role getRole(int id);
}