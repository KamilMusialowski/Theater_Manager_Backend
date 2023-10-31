package pl.polsl.musialowski_kamil.theater_manager_backend.dtos.theatreDtos;

import java.io.Serializable;

/**
 * DTO for {@link pl.polsl.musialowski_kamil.theater_manager_backend.model.Theatre}
 */
public record CreatedTheatreDto(Long id, String name, String city, String street, String zipCode, String voivodeship,
                                String country, String phoneNumber1, String phoneNumber2) implements Serializable {
}