package pl.polsl.musialowski_kamil.theater_manager_backend.dtos.systemRolesDto;

import pl.polsl.musialowski_kamil.theater_manager_backend.model.enums.SystemRoleEnum;

import java.io.Serializable;

/**
 * DTO for {@link pl.polsl.musialowski_kamil.theater_manager_backend.model.SystemRole}
 */
public record SystemRoleDto(Long id, SystemRoleEnum systemRole) implements Serializable {
}