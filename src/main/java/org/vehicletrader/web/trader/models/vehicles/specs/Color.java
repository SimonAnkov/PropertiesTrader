package org.vehicletrader.web.trader.models.vehicles.specs;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vehicle_colors")
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @EqualsAndHashCode.Include
    private int id;

    @Column(name = "color")
    @NonNull
    @Setter
    private String color;
}
