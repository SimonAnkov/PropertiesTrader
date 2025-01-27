package org.vehicletrader.web.trader.services.contracts;

import org.vehicletrader.web.trader.models.vehicles.VehicleListing;

import java.util.List;

public interface VehicleListingService {
    VehicleListing getVehicleListing(int vehicleId);

    List<VehicleListing> getVehicleListings();

    void addVehicleListing(VehicleListing vehicleListing);

    void updateVehicleListing(VehicleListing vehicleListing);

    void deleteVehicleListing(VehicleListing vehicleListing);
}
