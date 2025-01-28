package org.vehicletrader.web.trader.models.users.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PrivateUserDtoIn extends UserDtoIn {
    private String firstName;
    private String lastName;
}
