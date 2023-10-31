package pl.polsl.musialowski_kamil.theater_manager_backend.dtos.theatreDtos;

import java.io.Serializable;

/**
 * DTO for {@link pl.polsl.musialowski_kamil.theater_manager_backend.model.Theatre}
 */
public record TheatresListDto(Long id, String name, String city, String street) implements Serializable {
}