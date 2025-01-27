package org.vehicletrader.web.trader.models.specs;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "models")
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @EqualsAndHashCode.Include
    private int id;

    @ManyToOne
    @JoinColumn(name = "brand")
    @NonNull
    @Setter
    private Make make;

    @Column(name = "model")
    @NonNull
    @Setter
    private String model;
}
