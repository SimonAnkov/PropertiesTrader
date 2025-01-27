package org.vehicletrader.web.trader.models.vehicles.specs;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vehicle_fuels")
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Fuel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @EqualsAndHashCode.Include
    private int id;

    @Column(name = "fuel")
    @NonNull
    @Setter
    private String fuel;
}
