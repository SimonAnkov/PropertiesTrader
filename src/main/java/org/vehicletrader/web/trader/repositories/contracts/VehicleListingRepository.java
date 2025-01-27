package org.vehicletrader.web.trader.repositories.contracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vehicletrader.web.trader.models.VehicleListing;

@Repository
public interface VehicleListingRepository extends JpaRepository<VehicleListing, Integer> {
}
