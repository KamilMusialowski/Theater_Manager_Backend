package pl.polsl.musialowski_kamil.theater_manager_backend.dtos.theatrePersonelDtos;

import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.userDtos.UserListDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.enums.SystemRoleEnum;

import java.io.Serializable;

/**
 * DTO for {@link pl.polsl.musialowski_kamil.theater_manager_backend.model.TheatrePersonel}
 */
public record TheatrePersonelUserDto(UserListDto user, SystemRoleEnum roleEnum) implements Serializable {
}