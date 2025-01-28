package org.vehicletrader.web.trader.helpers;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.vehicletrader.web.trader.models.users.Private;
import org.vehicletrader.web.trader.models.users.Role;
import org.vehicletrader.web.trader.models.users.dtos.PrivateUserDtoIn;
import org.vehicletrader.web.trader.services.contracts.RoleService;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PrivateUserMappers {
    PrivateUserMappers INSTANCE = Mappers.getMapper(PrivateUserMappers.class);

    @Mapping(source = "username", target = "username")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "phone", target = "phone")
    @Mapping(target = "role", source = "privateUserDtoIn", qualifiedByName = "mapRole")
    Private fromDtoIn (PrivateUserDtoIn privateUserDtoIn, @Context RoleService roleService);

    @Named("mapRole")
    default Role mapRole(PrivateUserDtoIn privateUserDtoIn, @Context RoleService roleService) {
        return roleService.getRole("ROLE_PRIVATE");
    }
}
