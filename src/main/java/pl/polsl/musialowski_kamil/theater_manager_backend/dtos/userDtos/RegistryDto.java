package pl.polsl.musialowski_kamil.theater_manager_backend.dtos.userDtos;

import pl.polsl.musialowski_kamil.theater_manager_backend.model.enums.Sex;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link pl.polsl.musialowski_kamil.theater_manager_backend.model.User}
 */
public record RegistryDto(String firstName1, String firstName2, String lastName, String email, String password,
                          String phoneNumber, Sex sex) implements Serializable {
}