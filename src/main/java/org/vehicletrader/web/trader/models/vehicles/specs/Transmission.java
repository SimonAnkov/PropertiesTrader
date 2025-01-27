package org.vehicletrader.web.trader.models.vehicles.specs;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vehicle_transmissions")
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Transmission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @EqualsAndHashCode.Include
    private int id;

    @Column(name = "transmission")
    @NonNull
    @Setter
    private String transmission;
}
