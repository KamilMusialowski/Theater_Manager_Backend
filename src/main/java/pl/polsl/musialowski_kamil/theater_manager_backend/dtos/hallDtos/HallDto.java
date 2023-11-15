package pl.polsl.musialowski_kamil.theater_manager_backend.dtos.hallDtos;

import pl.polsl.musialowski_kamil.theater_manager_backend.dtos.theatreDtos.TheatresListDto;

import java.io.Serializable;

/**
 * DTO for {@link pl.polsl.musialowski_kamil.theater_manager_backend.model.Hall}
 */
public record HallDto(Long id, String name, Integer capacity, TheatresListDto theatre) implements Serializable {
}