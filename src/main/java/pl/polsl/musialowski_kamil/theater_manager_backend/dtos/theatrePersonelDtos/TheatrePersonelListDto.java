package pl.polsl.musialowski_kamil.theater_manager_backend.dtos.theatrePersonelDtos;

import pl.polsl.musialowski_kamil.theater_manager_backend.model.enums.SystemRoleEnum;

import java.io.Serializable;

/**
 * DTO for {@link pl.polsl.musialowski_kamil.theater_manager_backend.model.TheatrePersonel}
 */
public record TheatrePersonelListDto(Long id, Long userId, String userFirstName1, String userLastName,
                                     SystemRoleEnum roleEnum) implements Serializable {
}