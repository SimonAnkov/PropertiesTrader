package org.vehicletrader.web.trader.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.vehicletrader.web.trader.exceptions.EntityNotFoundException;
import org.vehicletrader.web.trader.models.users.Role;
import org.vehicletrader.web.trader.repositories.contracts.RoleRepository;
import org.vehicletrader.web.trader.services.contracts.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getRole(String roleName) {
        return roleRepository.findByRole(roleName)
                .orElseThrow(() -> new EntityNotFoundException("Role", "name", roleName));
    }

    @Override
    public Role getRole(int id) {
        return roleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Role", id));
    }
}
