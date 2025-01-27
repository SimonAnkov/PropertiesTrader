package org.vehicletrader.web.trader.models.users;

import jakarta.persistence.*;
import lombok.*;
import org.vehicletrader.web.trader.models.Location;

@Entity
@Table(name = "users_company")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Company extends User {

    @Column(name = "company_name")
    @NonNull
    private String companyName;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @Column(name = "company_address")
    @NonNull
    private String companyAddress;
}
