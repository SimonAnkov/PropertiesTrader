package org.vehicletrader.web.trader.models.users.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CompanyUserDtoIn extends UserDtoIn {
    private String companyName;
    private int companyLocationId;
    private String companyAddress;
}
