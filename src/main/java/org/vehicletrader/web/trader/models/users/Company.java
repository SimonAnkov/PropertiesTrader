package org.vehicletrader.web.trader.models.users;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "company_users")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Company extends User {

    @Column(name = "company_name")
    @NonNull
    private String companyName;

    @Column(name = "company_address")
    @NonNull
    private String companyAddress;
}
