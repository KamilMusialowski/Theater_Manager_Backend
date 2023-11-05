package pl.polsl.musialowski_kamil.theater_manager_backend.dtos.theatrePersonelDtos;

import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.theatreDtos.CreatedTheatreDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.userDtos.UserAllDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.model.enums.SystemRoleEnum;

import java.io.Serializable;

/**
 * DTO for {@link pl.polsl.musialowski_kamil.theater_manager_backend.model.TheatrePersonel}
 */
public record TheatrePersonelDto(String email, String theaterName,
                                 SystemRoleEnum roleEnum) implements Serializable {
}