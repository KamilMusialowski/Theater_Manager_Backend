package pl.polsl.musialowski_kamil.theater_manager_backend.dtos.userDtos;

import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.systemRolesDto.SystemRoleDto;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link pl.polsl.musialowski_kamil.theater_manager_backend.model.User}
 */
public record UserListDto(Long id, String firstName1, String lastName, String email,
                          Set<SystemRoleDto> systemRoles) implements Serializable {
}