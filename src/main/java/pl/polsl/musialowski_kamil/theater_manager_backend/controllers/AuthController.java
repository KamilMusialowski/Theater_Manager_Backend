package pl.polsl.musialowski_kamil.theater_manager_backend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.polsl.musialowski_kamil.theater_manager_backend.configurations.UserAuthProvider;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.userDtos.CredentialsDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.userDtos.RegistryDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.userDtos.UserAllDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.services.UserService;

import java.net.URI;

@RestController
public class AuthController {

    private final UserService userService;
    private final UserAuthProvider userAuthProvider;

    public AuthController(UserService userService, UserAuthProvider userAuthProvider) {
        this.userService = userService;
        this.userAuthProvider = userAuthProvider;
    }

    @PostMapping("/login")
    public ResponseEntity<UserAllDto> login(@RequestBody CredentialsDto credentialsDto) {
        UserAllDto user = userService.login(credentialsDto);
        user.setToken(userAuthProvider.createToken(user));
        return ResponseEntity.ok(user);
    }

    @PostMapping("/register")
    public ResponseEntity<UserAllDto> register(@RequestBody RegistryDto registryDto) {
        UserAllDto user = userService.register(registryDto);
        user.setToken(userAuthProvider.createToken(user));
        return ResponseEntity.created(URI.create("/users/" + user.getId())).body(user);
    }
}
