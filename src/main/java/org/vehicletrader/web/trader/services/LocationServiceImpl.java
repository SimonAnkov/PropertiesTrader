package org.vehicletrader.web.trader.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vehicletrader.web.trader.exceptions.EntityNotFoundException;
import org.vehicletrader.web.trader.models.Location;
import org.vehicletrader.web.trader.repositories.contracts.LocationRepository;
import org.vehicletrader.web.trader.services.contracts.LocationService;

@Service
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;

    @Autowired
    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public Location getLocation(int id) {
        return locationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Location", id));
    }
}
