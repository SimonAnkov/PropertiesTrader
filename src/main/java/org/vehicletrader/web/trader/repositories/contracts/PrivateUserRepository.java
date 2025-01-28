package org.vehicletrader.web.trader.repositories.contracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vehicletrader.web.trader.models.users.Private;

public interface PrivateUserRepository extends JpaRepository<Private, Integer> {
}
