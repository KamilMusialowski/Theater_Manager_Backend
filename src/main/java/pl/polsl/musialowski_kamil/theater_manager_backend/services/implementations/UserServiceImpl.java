package pl.polsl.musialowski_kamil.theater_manager_backend.services.implementations;


import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.userDtos.CredentialsDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.userDtos.RegistryDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.userDtos.UserAllDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.exceptions.AppException;
import pl.polsl.musialowski_kamil.theater_manager_backend.mappers.UserMapper;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.SystemRole;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.User;
import pl.polsl.musialowski_kamil.theater_manager_backend.repositories.UserRepository;
import pl.polsl.musialowski_kamil.theater_manager_backend.services.SystemRoleService;
import pl.polsl.musialowski_kamil.theater_manager_backend.services.UserService;

import java.nio.CharBuffer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final SystemRoleService systemRoleService;

    @Override
    public UserAllDto login(CredentialsDto credentialsDto) {
        User user = userRepository.findByEmail(credentialsDto.email())
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));

        if(passwordEncoder.matches(CharBuffer.wrap(credentialsDto.password()),
                user.getPassword())) {
            return userMapper.toUserDto(user);
        }
        throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
    }

    @Override
    public UserAllDto register(RegistryDto registryDto) {
        Optional<User> optionalUser = userRepository.findByEmail(registryDto.email());

        if(optionalUser.isPresent()) {
            throw new AppException("Email already used", HttpStatus.BAD_REQUEST);
        }

        User user = userMapper.toEntity(registryDto);

        user.setPassword(passwordEncoder.encode(CharBuffer.wrap(registryDto.password())));

        Set<SystemRole> test = user.getSystemRoles();
        Set<SystemRole> newSet = new HashSet<>();

        Iterator<SystemRole> it = test.iterator();

        while(it.hasNext()) {
            SystemRole sr = this.systemRoleService.saveRolesForUser(it.next());
            newSet.add(sr);
        }

        user.setSystemRoles(newSet);

        User savedUser = userRepository.save(user);
        return userMapper.toUserDto(savedUser);
    }

    @Override
    public Set<User> getUsers() {
        Set<User> users = new HashSet<>(this.userRepository.findAll());
        return users;
    }

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, UserMapper userMapper, SystemRoleService systemRoleService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
        this.systemRoleService = systemRoleService;
    }
}
