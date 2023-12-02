package pl.polsl.musialowski_kamil.theater_manager_backend.dtos.userDtos;

import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.eventReservationDtos.EventReservationsDto;
import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.systemRoleDtos.SystemRoleDto;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link pl.polsl.musialowski_kamil.theater_manager_backend.model.User}
 */

public class AuthenticatedUserDto {
    private Long id;
    private String firstName1;
    private String token;
    Set<SystemRoleDto> systemRoles;
    Set<EventReservationsDto> events;

    public AuthenticatedUserDto(Long id, String firstName1, String token, Set<SystemRoleDto> systemRoles, Set<EventReservationsDto> events) {
        this.id = id;
        this.firstName1 = firstName1;
        this.token = token;
        this.systemRoles = systemRoles;
        this.events = events;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName1() {
        return firstName1;
    }

    public void setFirstName1(String firstName1) {
        this.firstName1 = firstName1;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Set<SystemRoleDto> getSystemRoles() {
        return systemRoles;
    }

    public void setSystemRoles(Set<SystemRoleDto> systemRoles) {
        this.systemRoles = systemRoles;
    }

    public Set<EventReservationsDto> getEvents() {
        return events;
    }

    public void setEvents(Set<EventReservationsDto> events) {
        this.events = events;
    }
}