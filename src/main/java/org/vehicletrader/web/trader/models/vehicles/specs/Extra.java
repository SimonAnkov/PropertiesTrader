package org.vehicletrader.web.trader.models.vehicles.specs;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vehicle_extras")
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Extra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @EqualsAndHashCode.Include
    private int id;

    @Column(name = "extra")
    @NonNull
    @Setter
    private String extra;
}
