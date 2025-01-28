package org.vehicletrader.web.trader.repositories.contracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vehicletrader.web.trader.models.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {
}
