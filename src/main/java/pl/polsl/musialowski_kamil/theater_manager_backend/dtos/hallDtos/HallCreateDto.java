package pl.polsl.musialowski_kamil.theater_manager_backend.dtos.hallDtos;

import java.io.Serializable;

/**
 * DTO for {@link pl.polsl.musialowski_kamil.theater_manager_backend.model.Hall}
 */
public record HallCreateDto(String name, Integer capacity) implements Serializable {
}