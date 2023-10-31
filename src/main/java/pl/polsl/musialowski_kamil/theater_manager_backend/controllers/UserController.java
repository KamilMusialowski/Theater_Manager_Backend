package pl.polsl.musialowski_kamil.theater_manager_backend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.userDtos.UserListDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.mappers.UserMapper;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.User;
import pl.polsl.musialowski_kamil.theater_manager_backend.services.UserService;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService,
                          UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/usersRestrictedView")
    public ResponseEntity<Set<UserListDto>> getUsersForGridDisplay() {
        Set<User> users = userService.getUsers();
        Set<UserListDto> usersDto = users.stream()
                .map(userMapper::toDto)
                .collect(Collectors.toSet());
        return ResponseEntity.ok(usersDto);
    }
}
