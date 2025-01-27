package org.vehicletrader.web.trader.models;

import jakarta.persistence.*;
import lombok.*;
import org.vehicletrader.web.trader.models.specs.Color;
import org.vehicletrader.web.trader.models.specs.Model;
import org.vehicletrader.web.trader.models.specs.Type;
import org.vehicletrader.web.trader.models.users.User;

@Entity
@Table(name = "vehicle_listings")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class VehicleListing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @EqualsAndHashCode.Include
    private int id;

    @ManyToOne
    @JoinColumn(name = "type_id")
    @Setter
    private Type type;

    @ManyToOne
    @JoinColumn(name = "type_id")
    @Setter
    private Model model;

    @ManyToOne
    @JoinColumn(name = "color_id")
    @Setter
    private Color color;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    @Setter
    private User creator;

    @Column(name = "mileage")
    @Setter
    private Double mileage;

    @Column(name = "description")
    @Setter
    private String description;

    @Column(name = "price")
    @Setter
    private Double price;
}
