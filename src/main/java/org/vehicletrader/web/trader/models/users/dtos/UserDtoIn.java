package org.vehicletrader.web.trader.models.users.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserDtoIn {
    private String username;
    private String email;
    private String phone;
    private String password;
    private String confirmPassword;
}

