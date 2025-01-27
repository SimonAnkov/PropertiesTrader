package org.vehicletrader.web.trader.models.properties;

import jakarta.persistence.*;
import lombok.*;
import org.vehicletrader.web.trader.models.Location;
import org.vehicletrader.web.trader.models.users.User;
import org.vehicletrader.web.trader.models.vehicles.specs.Extra;

import java.util.Set;

@Entity
@Table(name = "property_listings")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PropertyListing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @EqualsAndHashCode.Include
    private int id;

    @Column(name = "description")
    @Setter
    private String description;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    @Setter
    private User creator;

    @Column(name = "price")
    @Setter
    private Double price;

    @Column(name = "size")
    @Setter
    private Integer size;

    @ManyToMany
    @JoinTable(
            name = "property_perks_specified",
            joinColumns = @JoinColumn(name = "property_listing_id"),
            inverseJoinColumns = @JoinColumn(name = "perk_id")
    )
    private Set<Extra> extras;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @Column(name = "address")
    @NonNull
    private String address;
}
