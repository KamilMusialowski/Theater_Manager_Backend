package pl.polsl.musialowski_kamil.theater_manager_backend.services;

import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.userDtos.CredentialsDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.userDtos.RegistryDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.userDtos.UserAllDto;

public interface UserService {
    UserAllDto login(CredentialsDto credentialsDto);

    UserAllDto register(RegistryDto registryDto);
}
