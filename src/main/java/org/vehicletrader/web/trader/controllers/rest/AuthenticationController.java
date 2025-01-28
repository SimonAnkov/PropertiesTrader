package org.vehicletrader.web.trader.controllers.rest;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.vehicletrader.web.trader.exceptions.EntityDuplicateException;
import org.vehicletrader.web.trader.helpers.CompanyUserMappers;
import org.vehicletrader.web.trader.helpers.PrivateUserMappers;
import org.vehicletrader.web.trader.models.users.AuthRequest;
import org.vehicletrader.web.trader.models.users.Company;
import org.vehicletrader.web.trader.models.users.Private;
import org.vehicletrader.web.trader.models.users.dtos.CompanyUserDtoIn;
import org.vehicletrader.web.trader.models.users.dtos.PrivateUserDtoIn;
import org.vehicletrader.web.trader.services.contracts.JwtService;
import org.vehicletrader.web.trader.services.contracts.LocationService;
import org.vehicletrader.web.trader.services.contracts.PrivateUserService;
import org.vehicletrader.web.trader.services.contracts.RoleService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final JwtService jwtService;
    private final PrivateUserService privateUserService;
    private final RoleService roleService;
    private final AuthenticationManager authenticationManager;
    private final LocationService locationService;

    @Autowired
    public AuthenticationController(JwtService jwtService,
                                    AuthenticationManager authenticationManager,
                                    PrivateUserService privateUserService,
                                    RoleService roleService,
                                    LocationService locationService) {
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.privateUserService = privateUserService;
        this.roleService = roleService;
        this.locationService = locationService;
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }

    @PostMapping("/user/private/register")
    public ResponseEntity<?> addNewPrivateUser(@Valid @RequestBody PrivateUserDtoIn privateUserDtoIn,
                                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(validationErrorMessages(bindingResult)); // Return errors as response
        }

        if (!privateUserDtoIn.getPassword().equals(privateUserDtoIn.getConfirmPassword())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Passwords do not match");
        }

        Private privateUser = PrivateUserMappers.INSTANCE.fromDtoIn(privateUserDtoIn, roleService);

        try {
            privateUserService.createPrivateUser(privateUser);
            return ResponseEntity.ok("Private User created");
        } catch (EntityDuplicateException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping("/user/company/register")
    public ResponseEntity<?> addNewCompanyUser(@Valid @RequestBody CompanyUserDtoIn companyUserDtoIn,
                                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(validationErrorMessages(bindingResult)); // Return errors as response
        }

        if (!companyUserDtoIn.getPassword().equals(companyUserDtoIn.getConfirmPassword())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Passwords do not match");
        }

        Company companyUser = CompanyUserMappers.INSTANCE.fromDtoIn(companyUserDtoIn, roleService, locationService);

        return null;
    }

    private List<String> validationErrorMessages(BindingResult bindingResult) {
        // Collect validation errors
        return bindingResult.getAllErrors().stream()
                .map(error -> {
                    if (error instanceof FieldError fieldError) {
                        return fieldError.getField() + ": " + fieldError.getDefaultMessage();
                    }
                    return error.getDefaultMessage();
                })
                .collect(Collectors.toList());
    }

    @GetMapping("/user/userProfile")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String userProfile() {
        return "Welcome to User Profile";
    }

    @GetMapping("/admin/adminProfile")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String adminProfile() {
        return "Welcome to Admin Profile";
    }

    @PostMapping("/generateToken")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
        );
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("Invalid user request!");
        }
    }
}
