package org.vehicletrader.web.trader.helpers;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.vehicletrader.web.trader.models.Location;
import org.vehicletrader.web.trader.models.users.Company;
import org.vehicletrader.web.trader.models.users.Role;
import org.vehicletrader.web.trader.models.users.dtos.CompanyUserDtoIn;
import org.vehicletrader.web.trader.services.contracts.LocationService;
import org.vehicletrader.web.trader.services.contracts.RoleService;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CompanyUserMappers {
    CompanyUserMappers INSTANCE = Mappers.getMapper(CompanyUserMappers.class);

    @Mapping(source = "username", target = "username")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "phone", target = "phone")
    @Mapping(source = "companyName", target = "companyName")
    @Mapping(target = "location", source = "companyUserDtoIn", qualifiedByName = "mapLocation")
    @Mapping(source = "companyAddress", target = "companyAddress")
    @Mapping(target = "role", source = "companyUserDtoIn", qualifiedByName = "mapRole")
    Company fromDtoIn(CompanyUserDtoIn companyUserDtoIn,
                      @Context RoleService roleService,
                      @Context LocationService locationService);

    @Named("mapRole")
    default Role mapRole(CompanyUserDtoIn companyUserDtoIn, @Context RoleService roleService) {
        return roleService.getRole("ROLE_COMPANY");
    }

    @Named("mapLocation")
    default Location mapLocation(CompanyUserDtoIn companyUserDtoIn, @Context LocationService locationService) {
        return locationService.getLocation(companyUserDtoIn.getCompanyLocationId());
    }
}
