package org.vehicletrader.web.trader.models.users;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "users_private")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Private extends User {

    @Column(name = "first_name")
    @NonNull
    private String firstName;

    @Column(name = "last_name")
    @NonNull
    private String lastName;
}
