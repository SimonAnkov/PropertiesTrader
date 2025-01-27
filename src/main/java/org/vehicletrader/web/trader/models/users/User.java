package org.vehicletrader.web.trader.models.users;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users_principal")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @EqualsAndHashCode.Include
    private int id;

    @Column(name = "username")
    @NonNull
    @Setter
    private String username;

    @Column(name = "email")
    @NonNull
    @Setter
    private String email;

    @Column(name = "phone")
    @NonNull
    @Setter
    private String phone;

    @ManyToOne
    @JoinColumn(name = "role_id")
    @Setter
    private Role role;

    @Column(name = "password")
    @NonNull
    @Setter
    private String password;
}
