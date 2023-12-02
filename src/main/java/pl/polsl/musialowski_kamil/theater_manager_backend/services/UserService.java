package pl.polsl.musialowski_kamil.theater_manager_backend.services;

import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.userDtos.CredentialsDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.userDtos.RegistryDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.userDtos.UserAllDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.userDtos.UserListDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.User;

import java.util.Set;

public interface UserService {
    UserAllDto login(CredentialsDto credentialsDto);

    UserAllDto register(RegistryDto registryDto);

    Set<User> getUsers();

    UserListDto changePassword(Long userId, String newPassword);
}
