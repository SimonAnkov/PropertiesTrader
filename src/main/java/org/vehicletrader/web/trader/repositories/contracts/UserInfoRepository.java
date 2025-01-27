package org.vehicletrader.web.trader.repositories.contracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vehicletrader.web.trader.models.users.User;

import java.util.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username); // Use 'email' if that is the correct field for login
}

