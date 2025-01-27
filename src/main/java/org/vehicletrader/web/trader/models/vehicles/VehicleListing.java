package org.vehicletrader.web.trader.models.vehicles;

import jakarta.persistence.*;
import lombok.*;
import org.vehicletrader.web.trader.models.Location;
import org.vehicletrader.web.trader.models.users.User;
import org.vehicletrader.web.trader.models.vehicles.specs.*;

import java.util.Set;

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
    @JoinColumn(name = "model_id")
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

    @ManyToOne
    @JoinColumn(name = "transmission_id")
    @Setter
    private Transmission transmission;

    @ManyToOne
    @JoinColumn(name = "fuel_id")
    @Setter
    private Fuel fuel;

    @ManyToMany
    @JoinTable(
            name = "vehicle_extras_specified",
            joinColumns = @JoinColumn(name = "vehicle_listing_id"),
            inverseJoinColumns = @JoinColumn(name = "extra_id")
    )
    private Set<Extra> extras;

    @Column(name = "description")
    @Setter
    private String description;

    @Column(name = "price")
    @Setter
    private Double price;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @Column(name = "address")
    private String address;
}
