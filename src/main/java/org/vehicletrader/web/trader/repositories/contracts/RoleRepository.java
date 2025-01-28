package org.vehicletrader.web.trader.repositories.contracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vehicletrader.web.trader.models.users.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByRole(String name);
}
