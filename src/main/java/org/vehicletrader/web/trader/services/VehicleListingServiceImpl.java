package org.vehicletrader.web.trader.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vehicletrader.web.trader.exceptions.EntityNotFoundException;
import org.vehicletrader.web.trader.models.vehicles.VehicleListing;
import org.vehicletrader.web.trader.repositories.contracts.VehicleListingRepository;
import org.vehicletrader.web.trader.services.contracts.VehicleListingService;

import java.util.List;

@Service
public class VehicleListingServiceImpl implements VehicleListingService {

    private final VehicleListingRepository vehicleListingRepository;

    @Autowired
    VehicleListingServiceImpl(VehicleListingRepository vehicleListingRepository) {
        this.vehicleListingRepository = vehicleListingRepository;
    }

    @Override
    public VehicleListing getVehicleListing(int vehicleId) {
        return vehicleListingRepository.findById(vehicleId)
                .orElseThrow(() -> new EntityNotFoundException("Vehicle", vehicleId));
    }

    @Override
    public List<VehicleListing> getVehicleListings() {
        return vehicleListingRepository.findAll();
    }

    @Override
    public void addVehicleListing(VehicleListing vehicleListing) {
        vehicleListingRepository.save(vehicleListing);
    }

    @Override
    public void updateVehicleListing(VehicleListing vehicleListing) {
        vehicleListingRepository.save(vehicleListing);
    }

    @Override
    public void deleteVehicleListing(VehicleListing vehicleListing) {
        vehicleListingRepository.delete(vehicleListing);
    }
}
